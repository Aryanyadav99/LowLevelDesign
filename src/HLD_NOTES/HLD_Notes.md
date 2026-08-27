# HLD — Core Architecture Notes

## Overall Request Flow
```text
Client → DNS → CDN → API Gateway → Load Balancer → Application Servers → Redis → Database
```
> Har system mein ye saare components mandatory nahi hote. Requirement ke hisaab se add/remove karte hain.

---

## 1. Client
**Client = request bhejne wala**

| Examples | Client generally handles |
|---|---|
| Web browser • Mobile app • Another service | UI • User input • Request generation • Response rendering • Token/session storage |

```text
Client → HTTP Request → Server
Server → HTTP Response → Client
```

## 2. Server
**Server = request process karne wala system.**

| Single Server | Distributed Servers |
|---|---|
| `Client → Server → DB` | `Client → LB → Server 1 / Server 2 / Server 3` |
| **Problem:** Single point of failure • Limited scalability • Traffic badha → server overload | **Benefits:** Horizontal scaling • High availability • Failure handling |

### Horizontal vs Vertical Scaling
| Vertical scaling | Horizontal scaling |
|---|---|
| `1 Server → More CPU / RAM` | `1 Server → Server 1 + Server 2 + Server 3` |
| — | Generally distributed systems mein horizontal scaling preferred. |

---

## 3. API Gateway
**API Gateway = single entry point for clients.**

```text
Client → API Gateway → Services
```

| Main Uses | Alternatives |
|---|---|
| Authentication / authorization • Routing • Rate limiting • Request validation • Logging • Monitoring • API versioning • Load balancing integration • Request/response transformation | Nginx • Kong • AWS API Gateway • Spring Cloud Gateway • Envoy |

**Example**
```text
/api/users     → User Service
/api/orders    → Order Service
/api/payments  → Payment Service
```

**Why API Gateway?**
```text
Without gateway: Client → User Service
                 Client → Order Service
                 Client → Payment Service

With gateway:    Client → Gateway → User / Order / Payment
```
Client ko internal service architecture ka knowledge nahi chahiye.

**Interview line:** API Gateway provides a centralized entry point for clients and handles cross-cutting concerns such as authentication, routing, rate limiting and monitoring.

---

## 4. Load Balancer
**Load Balancer ka kaam:** Incoming requests ko multiple servers mein distribute karna.

```text
                  → Server 1
Client → LB ─────→ Server 2
                  → Server 3
```

| Without LB | With LB |
|---|---|
| `Client → Server 1` | `LB → S1 / S2 / S3` |
| Server 1 overload ho sakta hai. | — |

**Benefits:** Scalability • High availability • Fault tolerance • Traffic distribution

### Load Balancing Algorithms
| Algorithm | Idea / Use |
|---|---|
| **1. Round Robin** | `R1→S1, R2→S2, R3→S3, R4→S1` — Simple and common. |
| **2. Weighted Round Robin** | Powerful server ko zyada requests. `S1→weight 3, S2→weight 1` → S1 gets roughly 3× traffic. |
| **3. Least Connections** | Request goes to server having least active connections. Useful when requests have different processing times. |
| **4. IP Hash** | Client IP → same server. `User A→S1` repeatedly. Useful when session state exists on server. But distributed systems mein better approach usually stateless servers + shared session/cache hota hai. |
| **5. Random** | Randomly select server. Simple but less intelligent. |

---

## 5. Redis
**Redis = in-memory key-value data store.**

**Main reason:** Database se bahut fast data access karna.

```text
Application
    ↓
 Redis
    ↓
Database
```

### Typical Use — Caching
```text
Request → Redis?
           ↓ YES → return
           ↓ NO
           DB
           ↓
      Redis mein store
```

**Example**
```text
GET product:123
product:123 → {...product data...}
```

| Redis Uses | Important Properties |
|---|---|
| Cache • Session storage • Distributed locking • Rate limiting • Counters • Pub/Sub • Leaderboards • Temporary data • TTL-based data | In-memory • Very low latency • Key-value based • TTL support • Distributed deployment possible • Persistence options available |

---

## 6. CDN
**CDN = Content Delivery Network**

**Main purpose:** Static content ko user ke geographically nearby edge server se serve karna.

```text
User India → CDN Edge India → Static content
```

Instead of:
```text
User India → Origin Server USA
```

**CDN commonly stores:** Images • CSS • JavaScript • Videos • Static HTML • Fonts • Other static assets

### Redis vs CDN — VERY IMPORTANT
Ye dono cache hain, **but same problem solve nahi karte.**

| Redis | CDN |
|---|---|
| Application-level cache | Network/edge-level cache |
| Usually dynamic data | Mostly static content |
| Near application/server | Near user |
| Product/user/session data | Images/CSS/JS/videos |
| App directly accesses it | Browser/CDN handles delivery |
| Very fast data lookup | Reduces network latency + origin load |

**Example**
```text
Product Image → CDN → User

Product API → Redis → Database
```

**So:**
- CDN = content delivery optimization
- Redis = application data access optimization

### CDN Request Flow
**First request**
```text
User → CDN → Cache MISS → Origin Server → CDN stores content → User
```

**Next request**
```text
User → CDN → Cache HIT → User
```
Origin server ko hit hi nahi karna pada.

**CDN benefits:** Lower latency • Reduced origin-server load • Better scalability • Faster static content delivery • DDoS protection often available depending on provider

**Examples:** Cloudflare • AWS CloudFront • Akamai

---

## 7. DNS
**DNS converts:** `google.com` → IP address

```text
Client → DNS → IP address → Server / CDN / LB
```

**HLD mein DNS ka use:** Domain → IP • Traffic routing • Failover • Sometimes geographic routing

---

## 8. Database

### SQL
**Examples:** PostgreSQL • MySQL

**Use when:** Strong consistency • Relationships • Transactions • Structured data

**Example:** Users • Orders • Payments

### NoSQL
**Examples:** MongoDB • Cassandra • DynamoDB

**Use when:** Massive scale • Flexible schema • High write/read throughput • Specific access patterns

---

## 9. DB Scaling

### Read Replicas
```text
             → Primary DB
Application → → Read Replica
             → Read Replica

Writes → Primary
Reads  → Replicas
```
Useful when read-heavy system.

### Sharding
Split data across multiple DB servers.

```text
User ID 1-1M   → Shard 1
User ID 1M-2M  → Shard 2
User ID 2M-3M  → Shard 3
```
Used when one DB cannot handle storage/traffic.

---

## 10. Message Queue
**For asynchronous processing.**

```text
Service → Queue → Worker
```

**Examples:** Kafka • RabbitMQ • AWS SQS

**Example**
```text
Order Created → Kafka → Notification Service
```

**Main benefits:** Async processing • Decoupling • Buffering • Retry • Handling traffic spikes

---

## 11. Stateless vs Stateful Server

### Stateful
Server remembers client state.

```text
User → Server 1 → Session
```

**Problem:** If next request goes Server 2 → session missing.

### Stateless
Server doesn't keep user session locally.

```text
Request → S1
Request → S2
Request → S3
```

Session/state stored externally:
```text
Servers → Redis / DB
```

Distributed systems mein stateless servers generally easier to scale.

---

## 12. Replication vs Sharding
**Ye interview mein confuse mat karna.**

| Replication | Sharding |
|---|---|
| **Same data → multiple servers** | **Different data → different servers** |
| `DB Primary → DB Replica → DB Replica` | `Users 1-1M→DB1, 1M-2M→DB2` |
| Purpose: Availability • Read scaling | Purpose: Storage scaling • Write/read scaling |

---

## 13. Cache Strategies

### Cache Aside — Most important
```text
App → Redis
      ↓ miss
      DB
      ↓
    Redis
```
Application itself manages cache.

### Write Through
```text
App → Cache → DB
```
Write cache and DB together.

### Write Back
```text
App → Cache
       ↓
    later DB
```
Faster but riskier because data can be lost before DB write.

---

## 14. CAP Theorem — HLD mein MUST

**Distributed system mein:**
- C = Consistency
- A = Availability
- P = Partition Tolerance

Network partition ke case mein:
```text
C + A
or
C + P
```
choose karna padta hai.

But real distributed systems mein P ko ignore nahi kar sakte, because network failures happen.

**Practical discussion:** Partition ke time system consistency prefer karega ya availability?

---

## 15. Consistency Types

| Strong Consistency | Eventual Consistency |
|---|---|
| Write ke immediately baad read → latest value. | Immediately latest value guaranteed nahi. |
| Useful: Banking • Payments • Seat booking | Eventually all replicas same state. Useful: Likes • Social feeds • Analytics • Some recommendation systems |

---

## 16. Rate Limiter
**Controls:** Client kitni requests/time period mein bhej sakta hai.

```text
Client → API Gateway / Rate Limiter → Allowed? → Service
                                      ↓
                                     429
```

**Algorithms:** Fixed Window • Sliding Window • Token Bucket • Leaky Bucket

Redis commonly used because multiple application servers ko shared centralized rate-limit state chahiye.

---

## 17. Distributed Lock
Multiple servers same resource modify kar rahe hain:

```text
S1 ──┐
     ├── Redis Lock → Resource
S2 ──┘
```

**Useful:** Seat booking • Inventory • Scheduled jobs • Preventing duplicate processing

---

## 18. Observability
Production HLD mein ye bhool gaya toh architecture half-baked lagega.

| Logs | Metrics | Tracing |
|---|---|---|
| What happened? | How much / how often? | Track complete request journey |
| — | CPU • Memory • QPS • Latency • Error rate | `Request → Gateway → Service A → Service B → DB` |

---

# THE ONE FLOW TO REMEMBER

```text
                         ┌───────────┐
                         │  Client   │
                         └─────┬─────┘
                               ↓
                         ┌───────────┐
                         │    DNS    │
                         └─────┬─────┘
                               ↓
                         ┌───────────┐
                         │    CDN    │
                         └─────┬─────┘
                               ↓
                         ┌───────────┐
                         │API Gateway│
                         └─────┬─────┘
                               ↓
                        ┌──────────────┐
                        │Load Balancer │
                        └──────┬───────┘
                               ↓
                     ┌─────────┼─────────┐
                     ↓         ↓         ↓
                    S1        S2        S3
                     │         │         │
                     └─────────┼─────────┘
                               ↓
                            Redis
                               ↓
                           Database
                               ↓
                         Read Replicas
```

### Side Notes
```text
Kafka → Async Processing
Redis → Cache / Lock / Rate Limiter
CDN → Static Content
LB → Traffic Distribution
API Gateway → Entry Point + Cross-cutting concerns
DB → Persistent Data
Kafka → Decoupling + Async
DNS → Domain Resolution
```

## HLD ka actual mantra

Har component ke liye bas **4 questions**:

> **1. Why do I need it?**  
> **2. What problem does it solve?**  
> **3. What are the alternatives?**  
> **4. What trade-off does it introduce?**

Agar ye 4 explain kar sakta hai, toh tu architecture **samajh raha hai**, sirf boxes nahi bana raha.
