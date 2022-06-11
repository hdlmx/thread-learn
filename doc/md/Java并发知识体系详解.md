# Java并发知识体系详解

>
> Java 并发相关知识体系详解，包含理论基础，线程基础，synchronized，volatile，final关键字, JUC框架等内容。

![img](https://pdai-1257820000.cos.ap-beijing.myqcloud.com/pdai.tech/public/_images/java/java-concurrent-overview-1.png)

## 相关文章

> **A. Java进阶 - Java 并发之基础**：首先全局的了解并发的知识体系，同时了解并发理论基础和线程基础，并发关键字等，这些是你理解Java并发框架的基础。@pdai

- [Java 并发 - 知识体系]()
- Java 并发 - 理论基础
  - 多线程的出现是要解决什么问题的?
  - 线程不安全是指什么? 举例说明
  - 并发出现线程不安全的本质什么? 可见性，原子性和有序性。
  - Java是怎么解决并发问题的? 3个关键字，JMM和8个Happens-Before
  - 线程安全是不是非真即假? 不是
  - 线程安全有哪些实现思路?
  - 如何理解并发和并行的区别?
- Java 并发 - 线程基础
  - 线程有哪几种状态? 分别说明从一种状态到另一种状态转变有哪些方式?
  - 通常线程有哪几种使用方式?
  - 基础线程机制有哪些?
  - 线程的中断方式有哪些?
  - 线程的互斥同步方式有哪些? 如何比较和选择?
  - 线程之间有哪些协作方式?
- Java并发 - Java中所有的锁
  - Java提供了种类丰富的锁，每种锁因其特性的不同，在适当的场景下能够展现出非常高的效率。本文旨在对锁相关源码、使用场景进行举例，为读者介绍主流锁的知识点，以及不同的锁的适用场景。
- 关键字: synchronized详解
  - Synchronized可以作用在哪里? 分别通过对象锁和类锁进行举例。
  - Synchronized本质上是通过什么保证线程安全的? 分三个方面回答：加锁和释放锁的原理，可重入原理，保证可见性原理。
  - Synchronized由什么样的缺陷?  Java Lock是怎么弥补这些缺陷的。
  - Synchronized和Lock的对比，和选择?
  - Synchronized在使用时有何注意事项?
  - Synchronized修饰的方法在抛出异常时,会释放锁吗?
  - 多个线程等待同一个snchronized锁的时候，JVM如何选择下一个获取锁的线程?
  - Synchronized使得同时只有一个线程可以执行，性能比较差，有什么提升的方法?
  - 我想更加灵活地控制锁的释放和获取(现在释放锁和获取锁的时机都被规定死了)，怎么办?
  - 什么是锁的升级和降级? 什么是JVM里的偏斜锁、轻量级锁、重量级锁?
  - 不同的JDK中对Synchronized有何优化?
- 关键字: volatile详解
  - volatile关键字的作用是什么?
  - volatile能保证原子性吗?
  - 之前32位机器上共享的long和double变量的为什么要用volatile? 现在64位机器上是否也要设置呢?
  - i++为什么不能保证原子性?
  - volatile是如何实现可见性的?  内存屏障。
  - volatile是如何实现有序性的?  happens-before等
  - 说下volatile的应用场景?
- 关键字: final详解
  - 所有的final修饰的字段都是编译期常量吗?
  - 如何理解private所修饰的方法是隐式的final?
  - 说说final类型的类如何拓展? 比如String是final类型，我们想写个MyString复用所有String中方法，同时增加一个新的toMyString()的方法，应该如何做?
  - final方法可以被重载吗? 可以
  - 父类的final方法能不能够被子类重写? 不可以
  - 说说final域重排序规则?
  - 说说final的原理?
  - 使用 final 的限制条件和局限性?
  - 看本文最后的一个思考题

> **B. Java进阶 - Java 并发之J.U.C框架**：然后需要对J.U.C框架五大类详细解读，包括：Lock框架，并发集合, 原子类, 线程池和工具类。@pdai

- JUC - 类汇总和学习指南
  - JUC框架包含几个部分?
  - 每个部分有哪些核心的类?
  - 最最核心的类有哪些?

> **B.1 Java进阶 - Java 并发之J.U.C框架【1/5】：CAS及原子类**：从最核心的CAS, Unsafe和原子类开始分析。

- JUC原子类: CAS, Unsafe和原子类详解
  - 线程安全的实现方法有哪些?
  - 什么是CAS?
  - CAS使用示例，结合AtomicInteger给出示例?
  - CAS会有哪些问题?
  - 针对这这些问题，Java提供了哪几个解决的?
  - AtomicInteger底层实现? CAS+volatile
  - 请阐述你对Unsafe类的理解?
  - 说说你对Java原子类的理解? 包含13个，4组分类，说说作用和使用场景。
  - AtomicStampedReference是什么?
  - AtomicStampedReference是怎么解决ABA的? 内部使用Pair来存储元素值及其版本号
  - java中还有哪些类可以解决ABA的问题? AtomicMarkableReference

> **B.2 Java进阶 - Java 并发之J.U.C框架【2/5】：锁**：然后分析JUC中锁。

- JUC锁: LockSupport详解
  - 为什么LockSupport也是核心基础类? AQS框架借助于两个类：Unsafe(提供CAS操作)和LockSupport(提供park/unpark操作)
  - 写出分别通过wait/notify和LockSupport的park/unpark实现同步?
  - LockSupport.park()会释放锁资源吗? 那么Condition.await()呢?
  - Thread.sleep()、Object.wait()、Condition.await()、LockSupport.park()的区别? 重点
  - 如果在wait()之前执行了notify()会怎样?
  - 如果在park()之前执行了unpark()会怎样?
- JUC锁: 锁核心类AQS详解
  - 什么是AQS? 为什么它是核心?
  - AQS的核心思想是什么? 它是怎么实现的? 底层数据结构等
  - AQS有哪些核心的方法?
  - AQS定义什么样的资源获取方式? AQS定义了两种资源获取方式：`独占`(只有一个线程能访问执行，又根据是否按队列的顺序分为`公平锁`和`非公平锁`，如`ReentrantLock`) 和`共享`(多个线程可同时访问执行，如`Semaphore`、`CountDownLatch`、 `CyclicBarrier` )。`ReentrantReadWriteLock`可以看成是组合式，允许多个线程同时对某一资源进行读。
  - AQS底层使用了什么样的设计模式? 模板
  - AQS的应用示例?
- JUC锁: ReentrantLock详解
  - 什么是可重入，什么是可重入锁? 它用来解决什么问题?
  - ReentrantLock的核心是AQS，那么它怎么来实现的，继承吗? 说说其类内部结构关系。
  - ReentrantLock是如何实现公平锁的?
  - ReentrantLock是如何实现非公平锁的?
  - ReentrantLock默认实现的是公平还是非公平锁?
  - 使用ReentrantLock实现公平和非公平锁的示例?
  - ReentrantLock和Synchronized的对比?
- JUC锁: ReentrantReadWriteLock详解
  - 为了有了ReentrantLock还需要ReentrantReadWriteLock?
  - ReentrantReadWriteLock底层实现原理?
  - ReentrantReadWriteLock底层读写状态如何设计的? 高16位为读锁，低16位为写锁
  - 读锁和写锁的最大数量是多少?
  - 本地线程计数器ThreadLocalHoldCounter是用来做什么的?
  - 缓存计数器HoldCounter是用来做什么的?
  - 写锁的获取与释放是怎么实现的?
  - 读锁的获取与释放是怎么实现的?
  - RentrantReadWriteLock为什么不支持锁升级?
  - 什么是锁的升降级? RentrantReadWriteLock为什么不支持锁升级?

> **B.3 Java进阶 - Java 并发之J.U.C框架【3/5】：集合**：再理解JUC中重要的支持并发的集合。

- JUC集合: ConcurrentHashMap详解
  - 为什么HashTable慢? 它的并发度是什么? 那么ConcurrentHashMap并发度是什么?
  - ConcurrentHashMap在JDK1.7和JDK1.8中实现有什么差别? JDK1.8解決了JDK1.7中什么问题
  - ConcurrentHashMap JDK1.7实现的原理是什么? 分段锁机制
  - ConcurrentHashMap JDK1.8实现的原理是什么? 数组+链表+红黑树，CAS
  - ConcurrentHashMap JDK1.7中Segment数(concurrencyLevel)默认值是多少? 为何一旦初始化就不可再扩容?
  - ConcurrentHashMap JDK1.7说说其put的机制?
  - ConcurrentHashMap JDK1.7是如何扩容的? rehash(注：segment 数组不能扩容，扩容是 segment 数组某个位置内部的数组 HashEntry<K,V>[] 进行扩容)
  - ConcurrentHashMap JDK1.8是如何扩容的? tryPresize
  - ConcurrentHashMap JDK1.8链表转红黑树的时机是什么? 临界值为什么是8?
  - ConcurrentHashMap JDK1.8是如何进行数据迁移的? transfer
- JUC集合: CopyOnWriteArrayList详解
  - 请先说说非并发集合中Fail-fast机制?
  - 再为什么说ArrayList查询快而增删慢?
  - 对比ArrayList说说CopyOnWriteArrayList的增删改查实现原理? COW基于拷贝
  - 再说下弱一致性的迭代器原理是怎么样的? `COWIterator<E>`
  - CopyOnWriteArrayList为什么并发安全且性能比Vector好?
  - CopyOnWriteArrayList有何缺陷，说说其应用场景?
- JUC集合: ConcurrentLinkedQueue详解
  - 要想用线程安全的队列有哪些选择? Vector，`Collections.synchronizedList( List<T> list)`, ConcurrentLinkedQueue等
  - ConcurrentLinkedQueue实现的数据结构?
  - ConcurrentLinkedQueue底层原理?  全程无锁(CAS)
  - ConcurrentLinkedQueue的核心方法有哪些? offer()，poll()，peek()，isEmpty()等队列常用方法
  - 说说ConcurrentLinkedQueue的HOPS(延迟更新的策略)的设计?
  - ConcurrentLinkedQueue适合什么样的使用场景?
- JUC集合: BlockingQueue详解
  - 什么是BlockingDeque?
  - BlockingQueue大家族有哪些? ArrayBlockingQueue, DelayQueue, LinkedBlockingQueue, SynchronousQueue...
  - BlockingQueue适合用在什么样的场景?
  - BlockingQueue常用的方法?
  - BlockingQueue插入方法有哪些? 这些方法(`add(o)`,`offer(o)`,`put(o)`,`offer(o, timeout, timeunit)`)的区别是什么?
  - BlockingDeque 与BlockingQueue有何关系，请对比下它们的方法?
  - BlockingDeque适合用在什么样的场景?
  - BlockingDeque大家族有哪些?
  - BlockingDeque 与BlockingQueue实现例子?

> **B.4 Java进阶 - Java 并发之J.U.C框架【4/5】：线程池**：再者分析JUC中非常常用的线程池等。

- JUC线程池: FutureTask详解
  - FutureTask用来解决什么问题的? 为什么会出现?
  - FutureTask类结构关系怎么样的?
  - FutureTask的线程安全是由什么保证的?
  - FutureTask结果返回机制?
  - FutureTask内部运行状态的转变?
  - FutureTask通常会怎么用? 举例说明。
- JUC线程池: ThreadPoolExecutor详解
  - 为什么要有线程池?
  - Java是实现和管理线程池有哪些方式?  请简单举例如何使用。
  - 为什么很多公司不允许使用Executors去创建线程池? 那么推荐怎么使用呢?
  - ThreadPoolExecutor有哪些核心的配置参数? 请简要说明
  - ThreadPoolExecutor可以创建哪是哪三种线程池呢?
  - 当队列满了并且worker的数量达到maxSize的时候，会怎么样?
  - 说说ThreadPoolExecutor有哪些RejectedExecutionHandler策略? 默认是什么策略?
  - 简要说下线程池的任务执行机制? execute –> addWorker –>runworker (getTask)
  - 线程池中任务是如何提交的?
  - 线程池中任务是如何关闭的?
  - 在配置线程池的时候需要考虑哪些配置因素?
  - 如何监控线程池的状态?
- JUC线程池: ScheduledThreadPool详解
  - ScheduledThreadPoolExecutor要解决什么样的问题?
  - ScheduledThreadPoolExecutor相比ThreadPoolExecutor有哪些特性?
  - ScheduledThreadPoolExecutor有什么样的数据结构，核心内部类和抽象类?
  - ScheduledThreadPoolExecutor有哪两个关闭策略? 区别是什么?
  - ScheduledThreadPoolExecutor中scheduleAtFixedRate 和 scheduleWithFixedDelay区别是什么?
  - 为什么ThreadPoolExecutor 的调整策略却不适用于 ScheduledThreadPoolExecutor?
  - Executors 提供了几种方法来构造 ScheduledThreadPoolExecutor?
- JUC线程池: Fork/Join框架详解
  - Fork/Join主要用来解决什么样的问题?
  - Fork/Join框架是在哪个JDK版本中引入的?
  - Fork/Join框架主要包含哪三个模块? 模块之间的关系是怎么样的?
  - ForkJoinPool类继承关系?
  - ForkJoinTask抽象类继承关系? 在实际运用中，我们一般都会继承 RecursiveTask 、RecursiveAction 或 CountedCompleter 来实现我们的业务需求，而不会直接继承 ForkJoinTask 类。
  - 整个Fork/Join 框架的执行流程/运行机制是怎么样的?
  - 具体阐述Fork/Join的分治思想和work-stealing 实现方式?
  - 有哪些JDK源码中使用了Fork/Join思想?
  - 如何使用Executors工具类创建ForkJoinPool?
  - 写一个例子: 用ForkJoin方式实现1+2+3+...+100000?
  - Fork/Join在使用时有哪些注意事项? 结合JDK中的斐波那契数列实例具体说明。

> **B.5 Java进阶 - Java 并发之J.U.C框架【5/5】：工具类**：最后来看下JUC中有哪些工具类，以及线程隔离术ThreadLocal。

- JUC工具类: CountDownLatch详解
  - 什么是CountDownLatch?
  - CountDownLatch底层实现原理?
  - CountDownLatch一次可以唤醒几个任务? 多个
  - CountDownLatch有哪些主要方法? await(),countDown()
  - CountDownLatch适用于什么场景?
  - 写道题：实现一个容器，提供两个方法，add，size 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束? 使用CountDownLatch 代替wait notify 好处。
- JUC工具类: CyclicBarrier详解
  - 什么是CyclicBarrier?
  - CyclicBarrier底层实现原理?
  - CountDownLatch和CyclicBarrier对比?
  - CyclicBarrier的核心函数有哪些?
  - CyclicBarrier适用于什么场景?
- JUC工具类: Semaphore详解
  - 什么是Semaphore?
  - Semaphore内部原理?
  - Semaphore常用方法有哪些? 如何实现线程同步和互斥的?
  - Semaphore适合用在什么场景?
  - 单独使用Semaphore是不会使用到AQS的条件队列?
  - Semaphore中申请令牌(acquire)、释放令牌(release)的实现?
  - Semaphore初始化有10个令牌，11个线程同时各调用1次acquire方法，会发生什么?
  - Semaphore初始化有10个令牌，一个线程重复调用11次acquire方法，会发生什么?
  - Semaphore初始化有1个令牌，1个线程调用一次acquire方法，然后调用两次release方法，之后另外一个线程调用acquire(2)方法，此线程能够获取到足够的令牌并继续运行吗?
  - Semaphore初始化有2个令牌，一个线程调用1次release方法，然后一次性获取3个令牌，会获取到吗?
- JUC工具类: Phaser详解
  - Phaser主要用来解决什么问题?
  - Phaser与CyclicBarrier和CountDownLatch的区别是什么?
  - 如果用CountDownLatch来实现Phaser的功能应该怎么实现?
  - Phaser运行机制是什么样的?
  - 给一个Phaser使用的示例?
- JUC工具类: Exchanger详解
  - Exchanger主要解决什么问题?
  - 对比SynchronousQueue，为什么说Exchanger可被视为 SynchronousQueue 的双向形式?
  - Exchanger在不同的JDK版本中实现有什么差别?
  - Exchanger实现机制?
  - Exchanger已经有了slot单节点，为什么会加入arena node数组? 什么时候会用到数组?
  - arena可以确保不同的slot在arena中是不会相冲突的，那么是怎么保证的呢?
  - 什么是伪共享，Exchanger中如何体现的?
  - Exchanger实现举例
- Java 并发 - ThreadLocal详解
  - 什么是ThreadLocal? 用来解决什么问题的?
  - 说说你对ThreadLocal的理解
  - ThreadLocal是如何实现线程隔离的?
  - 为什么ThreadLocal会造成内存泄露? 如何解决
  - 还有哪些使用ThreadLocal的应用场景?

> **C. Java进阶 - Java 并发之 本质与模式**：最后站在更高的角度看其本质(协作，分工和互斥)，同时总结上述知识点所使用的模式。@pdai

## 一、 Java 并发 - 理论基础

>
> 本文从理论的角度引入并发安全问题以及JMM应对并发问题的原理

- Java 并发 - 理论基础
  - [带着BAT大厂的面试问题去理解](#带着bat大厂的面试问题去理解)
  - [为什么需要多线程](#为什么需要多线程)
  - [线程不安全示例](#线程不安全示例)
  - 并发出现问题的根源: 并发三要素
    - [可见性: CPU缓存引起](#可见性-cpu缓存引起)
    - [原子性: 分时复用引起](#原子性-分时复用引起)
    - [有序性: 重排序引起](#有序性-重排序引起)
  - JAVA是怎么解决并发问题的: JMM(Java内存模型)
    - [关键字: volatile、synchronized 和 final](#关键字-volatilesynchronized-和-final)
    - Happens-Before 规则
      - [1. 单一线程原则](#1-单一线程原则)
      - [2. 管程锁定规则](#2-管程锁定规则)
      - [3. volatile 变量规则](#3-volatile-变量规则)
      - [4. 线程启动规则](#4-线程启动规则)
      - [5. 线程加入规则](#5-线程加入规则)
      - [6. 线程中断规则](#6-线程中断规则)
      - [7. 对象终结规则](#7-对象终结规则)
      - [8. 传递性](#8-传递性)
  - 线程安全: 不是一个非真即假的命题
    - [1. 不可变](#1-不可变)
    - [2. 绝对线程安全](#2-绝对线程安全)
    - [3. 相对线程安全](#3-相对线程安全)
    - [4. 线程兼容](#4-线程兼容)
    - [5. 线程对立](#5-线程对立)
  - 线程安全的实现方法
    - [1. 互斥同步](#1-互斥同步)
    - [2. 非阻塞同步](#2-非阻塞同步)
    - [3. 无同步方案](#3-无同步方案)

著作权归https://pdai.tech所有。 链接：https://www.pdai.tech/md/java/thread/java-thread-x-theorty.html

### 1.1带着BAT大厂的面试问题去理解

请带着这些问题继续后文，会很大程度上帮助你更好的理解并发理论基础

- 多线程的出现是要解决什么问题的?
- 线程不安全是指什么? 举例说明
- 并发出现线程不安全的本质什么? 可见性，原子性和有序性。
- Java是怎么解决并发问题的? 3个关键字，JMM和8个Happens-Before
- 线程安全是不是非真即假? 不是
- 线程安全有哪些实现思路?
- 如何理解并发和并行的区别?

### [¶1.2](#为什么需要多线程) 为什么需要多线程

众所周知，CPU、内存、I/O 设备的速度是有极大差异的，为了合理利用 CPU 的高性能，平衡这三者的速度差异，计算机体系结构、操作系统、编译程序都做出了贡献，主要体现为:

- CPU 增加了缓存，以均衡与内存的速度差异；// 导致 `可见性`问题
- 操作系统增加了进程、线程，以分时复用 CPU，进而均衡 CPU 与 I/O 设备的速度差异；// 导致 `原子性`问题
- 编译程序优化指令执行次序，使得缓存能够得到更加合理地利用。// 导致 `有序性`问题

### [¶](#线程不安全示例) 1.3线程不安全示例

如果多个线程对同一个共享数据进行访问而不采取同步操作的话，那么操作的结果是不一致的。

以下代码演示了 1000 个线程同时对 cnt 执行自增操作，操作结束之后它的值有可能小于 1000。

```java
public class ThreadUnsafeExample {

    private int cnt = 0;

    public void add() {
        cnt++;
    }

    public int get() {
        return cnt;
    }
}
```

```java
public static void main(String[] args) throws InterruptedException {
    final int threadSize = 1000;
    ThreadUnsafeExample example = new ThreadUnsafeExample();
    final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
    ExecutorService executorService = Executors.newCachedThreadPool();
    for (int i = 0; i < threadSize; i++) {
        executorService.execute(() -> {
            example.add();
            countDownLatch.countDown();
        });
    }
    countDownLatch.await();
    executorService.shutdown();
    System.out.println(example.get());
}
```

```
997 // 结果总是小于1000
```

### 1.4并发出现问题的根源: 并发三要素

上述代码输出为什么不是1000? 并发出现问题的根源是什么?

#### [¶](#可见性-cpu缓存引起) 1.4.1 可见性: CPU缓存引起

可见性：一个线程对共享变量的修改，另外一个线程能够立刻看到。

举个简单的例子，看下面这段代码：

```java
//线程1执行的代码
int i = 0;
i = 10;
 
//线程2执行的代码
j = i;
```

假若执行线程1的是CPU1，执行线程2的是CPU2。由上面的分析可知，当线程1执行 i =10这句时，会先把i的初始值加载到CPU1的高速缓存中，然后赋值为10，那么在CPU1的高速缓存当中i的值变为10了，却没有立即写入到主存当中。

此时线程2执行 j = i，它会先去主存读取i的值并加载到CPU2的缓存当中，注意此时内存当中i的值还是0，那么就会使得j的值为0，而不是10.

这就是可见性问题，线程1对变量i修改了之后，线程2没有立即看到线程1修改的值。

### 1.4.2 原子性: 分时复用引起

原子性：即一个操作或者多个操作 要么全部执行并且执行的过程不会被任何因素打断，要么就都不执行。

经典的**转账问题**：比如从账户A向账户B转1000元，那么必然包括2个操作：从账户A减去1000元，往账户B加上1000元。

试想一下，如果这2个操作不具备原子性，会造成什么样的后果。假如从账户A减去1000元之后，操作突然中止。然后又从B取出了500元，取出500元之后，再执行 往账户B加上1000元 的操作。这样就会导致账户A虽然减去了1000元，但是账户B没有收到这个转过来的1000元。

所以这2个操作必须要具备原子性才能保证不出现一些意外的问题。

### 1.4.3 有序性: 重排序引起

有序性：即程序执行的顺序按照代码的先后顺序执行。举个简单的例子，看下面这段代码：

```java
int i = 0;              
boolean flag = false;
i = 1;                //语句1  
flag = true;          //语句2
```

上面代码定义了一个int型变量，定义了一个boolean类型变量，然后分别对两个变量进行赋值操作。从代码顺序上看，语句1是在语句2前面的，那么JVM在真正执行这段代码的时候会保证语句1一定会在语句2前面执行吗? 不一定，为什么呢? 这里可能会发生指令重排序（Instruction Reorder）。

在执行程序时为了提高性能，编译器和处理器常常会对指令做重排序。重排序分三种类型：

- 编译器优化的重排序。编译器在不改变单线程程序语义的前提下，可以重新安排语句的执行顺序。
- 指令级并行的重排序。现代处理器采用了指令级并行技术（Instruction-Level Parallelism， ILP）来将多条指令重叠执行。如果不存在数据依赖性，处理器可以改变语句对应机器指令的执行顺序。
- 内存系统的重排序。由于处理器使用缓存和读 / 写缓冲区，这使得加载和存储操作看上去可能是在乱序执行。

从 java 源代码到最终实际执行的指令序列，会分别经历下面三种重排序：

![img](https://pdai-1257820000.cos.ap-beijing.myqcloud.com/pdai.tech/public/_images/jvm/java-jmm-3.png)

上述的 1 属于编译器重排序，2 和 3 属于处理器重排序。这些重排序都可能会导致多线程程序出现内存可见性问题。对于编译器，JMM 的编译器重排序规则会禁止特定类型的编译器重排序（不是所有的编译器重排序都要禁止）。对于处理器重排序，JMM 的处理器重排序规则会要求 java 编译器在生成指令序列时，插入特定类型的内存屏障（memory barriers，intel 称之为 memory fence）指令，通过内存屏障指令来禁止特定类型的处理器重排序（不是所有的处理器重排序都要禁止）。

具体可以参看：[Java 内存模型详解]()的重排序章节。

### 1.5 JAVA是怎么解决并发问题的: JMM(Java内存模型)

Java 内存模型是个很复杂的规范，强烈推荐你看后续（应该是网上能找到最好的材料之一了）：[Java 内存模型详解]()。

**理解的第一个维度：核心知识点**

JMM本质上可以理解为，Java 内存模型规范了 JVM 如何提供按需禁用缓存和编译优化的方法。具体来说，这些方法包括：

- volatile、synchronized 和 final 三个关键字
- Happens-Before 规则

**理解的第二个维度：可见性，有序性，原子性**

- 原子性

在Java中，对基本数据类型的变量的读取和赋值操作是原子性操作，即这些操作是不可被中断的，要么执行，要么不执行。 请分析以下哪些操作是原子性操作：

```java
x = 10;        //语句1: 直接将数值10赋值给x，也就是说线程执行这个语句的会直接将数值10写入到工作内存中
y = x;         //语句2: 包含2个操作，它先要去读取x的值，再将x的值写入工作内存，虽然读取x的值以及 将x的值写入工作内存 这2个操作都是原子性操作，但是合起来就不是原子性操作了。
x++;           //语句3： x++包括3个操作：读取x的值，进行加1操作，写入新的值。
x = x + 1;     //语句4： 同语句3
```

上面4个语句只有语句1的操作具备原子性。

也就是说，只有简单的读取、赋值（而且必须是将数字赋值给某个变量，变量之间的相互赋值不是原子操作）才是原子操作。

> 从上面可以看出，Java内存模型只保证了基本读取和赋值是原子性操作，如果要实现更大范围操作的原子性，可以通过synchronized和Lock来实现。由于synchronized和Lock能够保证任一时刻只有一个线程执行该代码块，那么自然就不存在原子性问题了，从而保证了原子性。

- 可见性

Java提供了volatile关键字来保证可见性。

当一个共享变量被volatile修饰时，它会保证修改的值会立即被更新到主存，当有其他线程需要读取时，它会去内存中读取新值。

而普通的共享变量不能保证可见性，因为普通共享变量被修改之后，什么时候被写入主存是不确定的，当其他线程去读取时，此时内存中可能还是原来的旧值，因此无法保证可见性。

> 另外，通过synchronized和Lock也能够保证可见性，synchronized和Lock能保证同一时刻只有一个线程获取锁然后执行同步代码，并且在释放锁之前会将对变量的修改刷新到主存当中。因此可以保证可见性。

- 有序性

在Java里面，可以通过volatile关键字来保证一定的“有序性”（具体原理在下一节讲述）。另外可以通过synchronized和Lock来保证有序性，很显然，synchronized和Lock保证每个时刻是有一个线程执行同步代码，相当于是让线程顺序执行同步代码，自然就保证了有序性。当然JMM是通过Happens-Before 规则来保证有序性的。

### 1.6 关键字: volatile、synchronized 和 final

以下三篇文章详细分析了这三个关键字：

- [关键字: synchronized详解](https://www.pdai.tech/md/java/thread/java-thread-x-key-synchronized.html)
- [关键字: volatile详解](https://www.pdai.tech/md/java/thread/java-thread-x-key-volatile.html)
- [关键字: final详解](https://www.pdai.tech/md/java/thread/java-thread-x-key-final.html)

### 1.7 Happens-Before 规则

上面提到了可以用 volatile 和 synchronized 来保证有序性。除此之外，JVM 还规定了先行发生原则，让一个操作无需控制就能先于另一个操作完成。

#### 1.7.1 单一线程原则

> Single Thread rule

在一个线程内，在程序前面的操作先行发生于后面的操作。

![image](https://www.pdai.tech/_images/pics/single-thread-rule.png)

#### 1.7.2 管程锁定规则

> Monitor Lock Rule

一个 unlock 操作先行发生于后面对同一个锁的 lock 操作。

![image](https://www.pdai.tech/_images/pics/monitor-lock-rule.png)

#### 1.7.3 volatile 变量规则

> Volatile Variable Rule

对一个 volatile 变量的写操作先行发生于后面对这个变量的读操作。

![image](https://www.pdai.tech/_images/pics/volatile-variable-rule.png)

#### 1.7.4 线程启动规则

> Thread Start Rule

Thread 对象的 start() 方法调用先行发生于此线程的每一个动作。

![image](https://www.pdai.tech/_images/pics/thread-start-rule.png)

#### 1.7.5 线程加入规则

> Thread Join Rule

Thread 对象的结束先行发生于 join() 方法返回。

![image](https://www.pdai.tech/_images/pics/thread-join-rule.png)

#### 1.7.6 线程中断规则

> Thread Interruption Rule

对线程 interrupt() 方法的调用先行发生于被中断线程的代码检测到中断事件的发生，可以通过 interrupted() 方法检测到是否有中断发生。

#### 1.7.7 对象终结规则

> Finalizer Rule

一个对象的初始化完成(构造函数执行结束)先行发生于它的 finalize() 方法的开始。

#### 1.7.8 传递性

> Transitivity

如果操作 A 先行发生于操作 B，操作 B 先行发生于操作 C，那么操作 A 先行发生于操作 C。

## 1.8 线程安全: 不是一个非真即假的命题

一个类在可以被多个线程安全调用时就是线程安全的。

线程安全不是一个非真即假的命题，可以将共享数据按照安全程度的强弱顺序分成以下五类: 不可变、绝对线程安全、相对线程安全、线程兼容和线程对立。

#### 1.8.1 不可变

不可变(Immutable)的对象一定是线程安全的，不需要再采取任何的线程安全保障措施。只要一个不可变的对象被正确地构建出来，永远也不会看到它在多个线程之中处于不一致的状态。

多线程环境下，应当尽量使对象成为不可变，来满足线程安全。

不可变的类型:

- final 关键字修饰的基本数据类型
- String
- 枚举类型
- Number 部分子类，如 Long 和 Double 等数值包装类型，BigInteger 和 BigDecimal 等大数据类型。但同为 Number 的原子类 AtomicInteger 和 AtomicLong 则是可变的。

对于集合类型，可以使用 Collections.unmodifiableXXX() 方法来获取一个不可变的集合。

```java
public class ImmutableExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(map);
        unmodifiableMap.put("a", 1);
    }
}
```

```java
Exception in thread "main" java.lang.UnsupportedOperationException
    at java.util.Collections$UnmodifiableMap.put(Collections.java:1457)
    at ImmutableExample.main(ImmutableExample.java:9)
```

Collections.unmodifiableXXX() 先对原始的集合进行拷贝，需要对集合进行修改的方法都直接抛出异常。

```java
public V put(K key, V value) {
    throw new UnsupportedOperationException();
}
```

#### 1.8.2 绝对线程安全

不管运行时环境如何，调用者都不需要任何额外的同步措施。

#### 1.8.3 相对线程安全

相对线程安全需要保证对这个对象单独的操作是线程安全的，在调用的时候不需要做额外的保障措施。但是对于一些特定顺序的连续调用，就可能需要在调用端使用额外的同步手段来保证调用的正确性。

在 Java 语言中，大部分的线程安全类都属于这种类型，例如 Vector、HashTable、Collections 的 synchronizedCollection() 方法包装的集合等。

对于下面的代码，如果删除元素的线程删除了 Vector 的一个元素，而获取元素的线程试图访问一个已经被删除的元素，那么就会抛出 ArrayIndexOutOfBoundsException。

```java
public class VectorUnsafeExample {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 100; i++) {
                vector.add(i);
            }
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.remove(i);
                }
            });
            executorService.execute(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.get(i);
                }
            });
            executorService.shutdown();
        }
    }
}
```

```java
Exception in thread "Thread-159738" java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 3
    at java.util.Vector.remove(Vector.java:831)
    at VectorUnsafeExample.lambda$main$0(VectorUnsafeExample.java:14)
    at VectorUnsafeExample$$Lambda$1/713338599.run(Unknown Source)
    at java.lang.Thread.run(Thread.java:745)
```

如果要保证上面的代码能正确执行下去，就需要对删除元素和获取元素的代码进行同步。

```java
executorService.execute(() -> {
    synchronized (vector) {
        for (int i = 0; i < vector.size(); i++) {
            vector.remove(i);
        }
    }
});
executorService.execute(() -> {
    synchronized (vector) {
        for (int i = 0; i < vector.size(); i++) {
            vector.get(i);
        }
    }
});
```

#### 1.8.4 线程兼容

线程兼容是指对象本身并不是线程安全的，但是可以通过在调用端正确地使用同步手段来保证对象在并发环境中可以安全地使用，我们平常说一个类不是线程安全的，绝大多数时候指的是这一种情况。Java API 中大部分的类都是属于线程兼容的，如与前面的 Vector 和 HashTable 相对应的集合类 ArrayList 和 HashMap 等。

#### 1.8.5 线程对立

线程对立是指无论调用端是否采取了同步措施，都无法在多线程环境中并发使用的代码。由于 Java 语言天生就具备多线程特性，线程对立这种排斥多线程的代码是很少出现的，而且通常都是有害的，应当尽量避免。

### 1.9 线程安全的实现方法

#### 1.9.1 互斥同步

synchronized 和 ReentrantLock。

初步了解你可以看：

- [Java 并发 - 线程基础：线程互斥同步]()

详细分析请看：

- [关键字: Synchronized详解]()
- [JUC锁: ReentrantLock详解]()

### 1.9.2 非阻塞同步

互斥同步最主要的问题就是线程阻塞和唤醒所带来的性能问题，因此这种同步也称为阻塞同步。

互斥同步属于一种悲观的并发策略，总是认为只要不去做正确的同步措施，那就肯定会出现问题。无论共享数据是否真的会出现竞争，它都要进行加锁(这里讨论的是概念模型，实际上虚拟机会优化掉很大一部分不必要的加锁)、用户态核心态转换、维护锁计数器和检查是否有被阻塞的线程需要唤醒等操作。

**(一)CAS**

随着硬件指令集的发展，我们可以使用基于冲突检测的乐观并发策略: 先进行操作，如果没有其它线程争用共享数据，那操作就成功了，否则采取补偿措施(不断地重试，直到成功为止)。这种乐观的并发策略的许多实现都不需要将线程阻塞，因此这种同步操作称为非阻塞同步。

乐观锁需要操作和冲突检测这两个步骤具备原子性，这里就不能再使用互斥同步来保证了，只能靠硬件来完成。硬件支持的原子性操作最典型的是: 比较并交换(Compare-and-Swap，CAS)。CAS 指令需要有 3 个操作数，分别是内存地址 V、旧的预期值 A 和新值 B。当执行操作时，只有当 V 的值等于 A，才将 V 的值更新为 B。

**(二)AtomicInteger**

J.U.C 包里面的整数原子类 AtomicInteger，其中的 compareAndSet() 和 getAndIncrement() 等方法都使用了 Unsafe 类的 CAS 操作。

以下代码使用了 AtomicInteger 执行了自增的操作。

```java
private AtomicInteger cnt = new AtomicInteger();

public void add() {
    cnt.incrementAndGet();
}
```

以下代码是 incrementAndGet() 的源码，它调用了 unsafe 的 getAndAddInt() 。

```java
public final int incrementAndGet() {
    return unsafe.getAndAddInt(this, valueOffset, 1) + 1;
}
```

以下代码是 getAndAddInt() 源码，var1 指示对象内存地址，var2 指示该字段相对对象内存地址的偏移，var4 指示操作需要加的数值，这里为 1。通过 getIntVolatile(var1, var2) 得到旧的预期值，通过调用 compareAndSwapInt() 来进行 CAS 比较，如果该字段内存地址中的值等于 var5，那么就更新内存地址为 var1+var2 的变量为 var5+var4。

可以看到 getAndAddInt() 在一个循环中进行，发生冲突的做法是不断的进行重试。

```java
public final int getAndAddInt(Object var1, long var2, int var4) {
    int var5;
    do {
        var5 = this.getIntVolatile(var1, var2);
    } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));

    return var5;
}
```

**(三)ABA**

如果一个变量初次读取的时候是 A 值，它的值被改成了 B，后来又被改回为 A，那 CAS 操作就会误认为它从来没有被改变过。

J.U.C 包提供了一个带有标记的原子引用类 AtomicStampedReference 来解决这个问题，它可以通过控制变量值的版本来保证 CAS 的正确性。大部分情况下 ABA 问题不会影响程序并发的正确性，如果需要解决 ABA 问题，改用传统的互斥同步可能会比原子类更高效。

CAS, Unsafe和原子类详细分析请看：

- [JUC原子类: CAS, Unsafe和原子类详解](https://www.pdai.tech/md/java/thread/java-thread-x-juc-AtomicInteger.html)

### 3. 无同步方案

要保证线程安全，并不是一定就要进行同步。如果一个方法本来就不涉及共享数据，那它自然就无须任何同步措施去保证正确性。

**(一)栈封闭**

多个线程访问同一个方法的局部变量时，不会出现线程安全问题，因为局部变量存储在虚拟机栈中，属于线程私有的。

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StackClosedExample {
    public void add100() {
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            cnt++;
        }
        System.out.println(cnt);
    }
}
```

```java
public static void main(String[] args) {
    StackClosedExample example = new StackClosedExample();
    ExecutorService executorService = Executors.newCachedThreadPool();
    executorService.execute(() -> example.add100());
    executorService.execute(() -> example.add100());
    executorService.shutdown();
}
```

```html
100
100
```

更详细的分析请看J.U.C中线程池相关内容详解：

- [JUC线程池: FutureTask详解]()
- [JUC线程池: ThreadPoolExecutor详解]()
- [JUC线程池: ScheduledThreadPool详解]()
- [JUC线程池: Fork/Join框架详解]()

**(二)线程本地存储(Thread Local Storage)**

如果一段代码中所需要的数据必须与其他代码共享，那就看看这些共享数据的代码是否能保证在同一个线程中执行。如果能保证，我们就可以把共享数据的可见范围限制在同一个线程之内，这样，无须同步也能保证线程之间不出现数据争用的问题。

符合这种特点的应用并不少见，大部分使用消费队列的架构模式(如“生产者-消费者”模式)都会将产品的消费过程尽量在一个线程中消费完。其中最重要的一个应用实例就是经典 Web 交互模型中的“一个请求对应一个服务器线程”(Thread-per-Request)的处理方式，这种处理方式的广泛应用使得很多 Web 服务端应用都可以使用线程本地存储来解决线程安全问题。

可以使用 java.lang.ThreadLocal 类来实现线程本地存储功能。

对于以下代码，thread1 中设置 threadLocal 为 1，而 thread2 设置 threadLocal 为 2。过了一段时间之后，thread1 读取 threadLocal 依然是 1，不受 thread2 的影响。

```java
public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        Thread thread1 = new Thread(() -> {
            threadLocal.set(1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
            threadLocal.remove();
        });
        Thread thread2 = new Thread(() -> {
            threadLocal.set(2);
            threadLocal.remove();
        });
        thread1.start();
        thread2.start();
    }
}
```

输出结果

```
1
```

为了理解 ThreadLocal，先看以下代码:

```java
public class ThreadLocalExample1 {
    public static void main(String[] args) {
        ThreadLocal threadLocal1 = new ThreadLocal();
        ThreadLocal threadLocal2 = new ThreadLocal();
        Thread thread1 = new Thread(() -> {
            threadLocal1.set(1);
            threadLocal2.set(1);
        });
        Thread thread2 = new Thread(() -> {
            threadLocal1.set(2);
            threadLocal2.set(2);
        });
        thread1.start();
        thread2.start();
    }
}
```

它所对应的底层结构图为:

![image](https://www.pdai.tech/_images/pics/3646544a-cb57-451d-9e03-d3c4f5e4434a.png)

每个 Thread 都有一个 ThreadLocal.ThreadLocalMap 对象，Thread 类中就定义了 ThreadLocal.ThreadLocalMap 成员。

```java
/* ThreadLocal values pertaining to this thread. This map is maintained
 * by the ThreadLocal class. */
ThreadLocal.ThreadLocalMap threadLocals = null;
```

当调用一个 ThreadLocal 的 set(T value) 方法时，先得到当前线程的 ThreadLocalMap 对象，然后将 ThreadLocal->value 键值对插入到该 Map 中。

```java
public void set(T value) {
    Thread t = Thread.currentThread();
    ThreadLocalMap map = getMap(t);
    if (map != null)
        map.set(this, value);
    else
        createMap(t, value);
}
```

get() 方法类似。

```java
public T get() {
    Thread t = Thread.currentThread();
    ThreadLocalMap map = getMap(t);
    if (map != null) {
        ThreadLocalMap.Entry e = map.getEntry(this);
        if (e != null) {
            @SuppressWarnings("unchecked")
            T result = (T)e.value;
            return result;
        }
    }
    return setInitialValue();
}
```

ThreadLocal 从理论上讲并不是用来解决多线程并发问题的，因为根本不存在多线程竞争。

在一些场景 (尤其是使用线程池) 下，由于 ThreadLocal.ThreadLocalMap 的底层数据结构导致 ThreadLocal 有内存泄漏的情况，应该尽可能在每次使用 ThreadLocal 后手动调用 remove()，以避免出现 ThreadLocal 经典的内存泄漏甚至是造成自身业务混乱的风险。

更详细的分析看：[Java 并发 - ThreadLocal详解](https://www.pdai.tech/md/java/thread/java-thread-x-threadlocal.html)

著作权归https://pdai.tech所有。 链接：https://www.pdai.tech/md/java/thread/java-thread-x-theorty.html

**(三)可重入代码(Reentrant Code)**

这种代码也叫做纯代码(Pure Code)，可以在代码执行的任何时刻中断它，转而去执行另外一段代码(包括递归调用它本身)，而在控制权返回后，原来的程序不会出现任何错误。

可重入代码有一些共同的特征，例如不依赖存储在堆上的数据和公用的系统资源、用到的状态量都由参数中传入、不调用非可重入的方法等。

## 二、Java 并发 - 线程基础

> 本文主要概要性的介绍线程的基础，为后面的章节深入介绍Java并发的知识提供基础。@pdai

- Java 并发 - 线程基础
  - 线程状态转换
    - [新建(New)](#新建new)
    - [可运行(Runnable)](#可运行runnable)
    - [阻塞(Blocking)](#阻塞blocking)
    - [无限期等待(Waiting)](#无限期等待waiting)
    - [限期等待(Timed Waiting)](#限期等待timed-waiting)
    - [死亡(Terminated)](#死亡terminated)
  - 线程使用方式
    - [实现 Runnable 接口](#实现-runnable-接口)
    - [实现 Callable 接口](#实现-callable-接口)
    - [继承 Thread 类](#继承-thread-类)
    - [实现接口 VS 继承 Thread](#实现接口-vs-继承-thread)
  - 基础线程机制
    - [Executor](#executor)
    - [Daemon](#daemon)
    - [sleep()](#sleep)
    - [yield()](#yield)
  - 线程中断
    - [InterruptedException](#interruptedexception)
    - [interrupted()](#interrupted)
    - [Executor 的中断操作](#executor-的中断操作)
  - 线程互斥同步
    - [synchronized](#synchronized)
    - [ReentrantLock](#reentrantlock)
    - [比较](#比较)
    - [使用选择](#使用选择)
  - 线程之间的协作
    - [join()](#join)
    - [wait() notify() notifyAll()](#wait-notify-notifyall)
    - [await() signal() signalAll()](#await-signal-signalall)

### 2.1带着BAT大厂的面试问题去理解

> TIP
>
> 请带着这些问题继续后文，会很大程度上帮助你更好的理解线程基础。

- 线程有哪几种状态? 分别说明从一种状态到另一种状态转变有哪些方式?
- 通常线程有哪几种使用方式?
- 基础线程机制有哪些?
- 线程的中断方式有哪些?
- 线程的互斥同步方式有哪些? 如何比较和选择?
- 线程之间有哪些协作方式?

### 2.2 线程状态转换

![image](https://www.pdai.tech/_images/pics/ace830df-9919-48ca-91b5-60b193f593d2.png)

#### 2.2.1 新建(New)

创建后尚未启动。

#### 2.2.2 可运行(Runnable)

可能正在运行，也可能正在等待 CPU 时间片。

包含了操作系统线程状态中的 Running 和 Ready。

#### 2.2.3 阻塞(Blocking)

等待获取一个排它锁，如果其线程释放了锁就会结束此状态。

#### 2.2.4 无限期等待(Waiting)

等待其它线程显式地唤醒，否则不会被分配 CPU 时间片。

| 进入方法                                   | 退出方法                             |
| ------------------------------------------ | ------------------------------------ |
| 没有设置 Timeout 参数的 Object.wait() 方法 | Object.notify() / Object.notifyAll() |
| 没有设置 Timeout 参数的 Thread.join() 方法 | 被调用的线程执行完毕                 |
| LockSupport.park() 方法                    | -                                    |

#### 2.2.5 限期等待(Timed Waiting)

无需等待其它线程显式地唤醒，在一定时间之后会被系统自动唤醒。

调用 Thread.sleep() 方法使线程进入限期等待状态时，常常用“使一个线程睡眠”进行描述。

调用 Object.wait() 方法使线程进入限期等待或者无限期等待时，常常用“挂起一个线程”进行描述。

睡眠和挂起是用来描述行为，而阻塞和等待用来描述状态。

阻塞和等待的区别在于，阻塞是被动的，它是在等待获取一个排它锁。而等待是主动的，通过调用 Thread.sleep() 和 Object.wait() 等方法进入。

| 进入方法                                 | 退出方法                                        |
| ---------------------------------------- | ----------------------------------------------- |
| Thread.sleep() 方法                      | 时间结束                                        |
| 设置了 Timeout 参数的 Object.wait() 方法 | 时间结束 / Object.notify() / Object.notifyAll() |
| 设置了 Timeout 参数的 Thread.join() 方法 | 时间结束 / 被调用的线程执行完毕                 |
| LockSupport.parkNanos() 方法             | -                                               |
| LockSupport.parkUntil() 方法             | -                                               |

#### 2.2.6 死亡(Terminated)

可以是线程结束任务之后自己结束，或者产生了异常而结束。

### 2.3 线程使用方式

有三种使用线程的方法:

- 实现 Runnable 接口；
- 实现 Callable 接口；
- 继承 Thread 类。

实现 Runnable 和 Callable 接口的类只能当做一个可以在线程中运行的任务，不是真正意义上的线程，因此最后还需要通过 Thread 来调用。可以说任务是通过线程驱动从而执行的。

#### 2.3.1 实现 Runnable 接口

需要实现 run() 方法。

通过 Thread 调用 start() 方法来启动线程。

```java
public class MyRunnable implements Runnable {
    public void run() {
        // ...
    }
}
```

```java
public static void main(String[] args) {
    MyRunnable instance = new MyRunnable();
    Thread thread = new Thread(instance);
    thread.start();
}
```

#### 2.3.2 实现 Callable 接口

与 Runnable 相比，Callable 可以有返回值，返回值通过 FutureTask 进行封装。

```java
public class MyCallable implements Callable<Integer> {
    public Integer call() {
        return 123;
    }
}
```

```java
public static void main(String[] args) throws ExecutionException, InterruptedException {
    MyCallable mc = new MyCallable();
    FutureTask<Integer> ft = new FutureTask<>(mc);
    Thread thread = new Thread(ft);
    thread.start();
    System.out.println(ft.get());
}
```

#### 2.3.3 继承 Thread 类

同样也是需要实现 run() 方法，因为 Thread 类也实现了 Runable 接口。

当调用 start() 方法启动一个线程时，虚拟机会将该线程放入就绪队列中等待被调度，当一个线程被调度时会执行该线程的 run() 方法。

```java
public class MyThread extends Thread {
    public void run() {
        // ...
    }
}
```

```java
public static void main(String[] args) {
    MyThread mt = new MyThread();
    mt.start();
}
```

**实现接口 VS 继承 Thread**

实现接口会更好一些，因为:

- Java 不支持多重继承，因此继承了 Thread 类就无法继承其它类，但是可以实现多个接口；
- 类可能只要求可执行就行，继承整个 Thread 类开销过大。

### 2.4 基础线程机制

#### 2.4.1 Executor

Executor 管理多个异步任务的执行，而无需程序员显式地管理线程的生命周期。这里的异步是指多个任务的执行互不干扰，不需要进行同步操作。

主要有三种 Executor:

- CachedThreadPool: 一个任务创建一个线程；
- FixedThreadPool: 所有任务只能使用固定大小的线程；
- SingleThreadExecutor: 相当于大小为 1 的 FixedThreadPool。

```java
public static void main(String[] args) {
    ExecutorService executorService = Executors.newCachedThreadPool();
    for (int i = 0; i < 5; i++) {
        executorService.execute(new MyRunnable());
    }
    executorService.shutdown();
}
```

#### 2.4.2 Daemon

守护线程是程序运行时在后台提供服务的线程，不属于程序中不可或缺的部分。当所有非守护线程结束时，程序也就终止，同时会杀死所有守护线程。main() 属于非守护线程。使用 setDaemon() 方法将一个线程设置为守护线程。

```java
public static void main(String[] args) {
    Thread thread = new Thread(new MyRunnable());
    thread.setDaemon(true);
}
```

#### 2.4.3 sleep()

Thread.sleep(millisec) 方法会休眠当前正在执行的线程，millisec 单位为毫秒。

sleep() 可能会抛出 InterruptedException，因为异常不能跨线程传播回 main() 中，因此必须在本地进行处理。线程中抛出的其它异常也同样需要在本地进行处理。

```java
public void run() {
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
```

#### 2.4.4 yield()

对静态方法 Thread.yield() 的调用声明了当前线程已经完成了生命周期中最重要的部分，可以切换给其它线程来执行。该方法只是对线程调度器的一个建议，而且也只是建议具有相同优先级的其它线程可以运行。

```java
public void run() {
    Thread.yield();
}
```

### 2.5 线程中断

一个线程执行完毕之后会自动结束，如果在运行过程中发生异常也会提前结束。

#### 2.5.1 InterruptedException

通过调用一个线程的 interrupt() 来中断该线程，如果该线程处于阻塞、限期等待或者无限期等待状态，那么就会抛出 InterruptedException，从而提前结束该线程。但是不能中断 I/O 阻塞和 synchronized 锁阻塞。

对于以下代码，在 main() 中启动一个线程之后再中断它，由于线程中调用了 Thread.sleep() 方法，因此会抛出一个 InterruptedException，从而提前结束线程，不执行之后的语句。

```java
public class InterruptExample {

    private static class MyThread1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

```java
public static void main(String[] args) throws InterruptedException {
    Thread thread1 = new MyThread1();
    thread1.start();
    thread1.interrupt();
    System.out.println("Main run");
}
```

```java
Main run
java.lang.InterruptedException: sleep interrupted
    at java.lang.Thread.sleep(Native Method)
    at InterruptExample.lambda$main$0(InterruptExample.java:5)
    at InterruptExample$$Lambda$1/713338599.run(Unknown Source)
    at java.lang.Thread.run(Thread.java:745)
```

#### 2.5.2 interrupted()

如果一个线程的 run() 方法执行一个无限循环，并且没有执行 sleep() 等会抛出 InterruptedException 的操作，那么调用线程的 interrupt() 方法就无法使线程提前结束。

但是调用 interrupt() 方法会设置线程的中断标记，此时调用 interrupted() 方法会返回 true。因此可以在循环体中使用 interrupted() 方法来判断线程是否处于中断状态，从而提前结束线程。

```java
public class InterruptExample {

    private static class MyThread2 extends Thread {
        @Override
        public void run() {
            while (!interrupted()) {
                // ..
            }
            System.out.println("Thread end");
        }
    }
}
```

```java
public static void main(String[] args) throws InterruptedException {
    Thread thread2 = new MyThread2();
    thread2.start();
    thread2.interrupt();
}
```

```java
Thread end
```

#### 2.5.3 Executor 的中断操作

调用 Executor 的 shutdown() 方法会等待线程都执行完毕之后再关闭，但是如果调用的是 shutdownNow() 方法，则相当于调用每个线程的 interrupt() 方法。

以下使用 Lambda 创建线程，相当于创建了一个匿名内部线程。

```java
public static void main(String[] args) {
    ExecutorService executorService = Executors.newCachedThreadPool();
    executorService.execute(() -> {
        try {
            Thread.sleep(2000);
            System.out.println("Thread run");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });
    executorService.shutdownNow();
    System.out.println("Main run");
}
```

```java
Main run
java.lang.InterruptedException: sleep interrupted
    at java.lang.Thread.sleep(Native Method)
    at ExecutorInterruptExample.lambda$main$0(ExecutorInterruptExample.java:9)
    at ExecutorInterruptExample$$Lambda$1/1160460865.run(Unknown Source)
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
    at java.lang.Thread.run(Thread.java:745)
```

如果只想中断 Executor 中的一个线程，可以通过使用 submit() 方法来提交一个线程，它会返回一个 Future<?> 对象，通过调用该对象的 cancel(true) 方法就可以中断线程。

```java
Future<?> future = executorService.submit(() -> {
    // ..
});
future.cancel(true);
```

### 2.6 线程互斥同步

Java 提供了两种锁机制来控制多个线程对共享资源的互斥访问，第一个是 JVM 实现的 synchronized，而另一个是 JDK 实现的 ReentrantLock。

#### 2.6.1 synchronized

**1. 同步一个代码块**

```java
public void func() {
    synchronized (this) {
        // ...
    }
}
```

它只作用于同一个对象，如果调用两个对象上的同步代码块，就不会进行同步。

对于以下代码，使用 ExecutorService 执行了两个线程，由于调用的是同一个对象的同步代码块，因此这两个线程会进行同步，当一个线程进入同步语句块时，另一个线程就必须等待。

```java
public class SynchronizedExample {

    public void func1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
```

```java
public static void main(String[] args) {
    SynchronizedExample e1 = new SynchronizedExample();
    ExecutorService executorService = Executors.newCachedThreadPool();
    executorService.execute(() -> e1.func1());
    executorService.execute(() -> e1.func1());
}
```

```
0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9
```

对于以下代码，两个线程调用了不同对象的同步代码块，因此这两个线程就不需要同步。从输出结果可以看出，两个线程交叉执行。

```java
public static void main(String[] args) {
    SynchronizedExample e1 = new SynchronizedExample();
    SynchronizedExample e2 = new SynchronizedExample();
    ExecutorService executorService = Executors.newCachedThreadPool();
    executorService.execute(() -> e1.func1());
    executorService.execute(() -> e2.func1());
}
```

```
0 0 1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9
```

**2. 同步一个方法**

```java
public synchronized void func () {
    // ...
}
```

它和同步代码块一样，作用于同一个对象。

**3. 同步一个类**

```java
public void func() {
    synchronized (SynchronizedExample.class) {
        // ...
    }
}
```

作用于整个类，也就是说两个线程调用同一个类的不同对象上的这种同步语句，也会进行同步。

```java
public class SynchronizedExample {

    public void func2() {
        synchronized (SynchronizedExample.class) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
```

```java
public static void main(String[] args) {
    SynchronizedExample e1 = new SynchronizedExample();
    SynchronizedExample e2 = new SynchronizedExample();
    ExecutorService executorService = Executors.newCachedThreadPool();
    executorService.execute(() -> e1.func2());
    executorService.execute(() -> e2.func2());
}
```

```
0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9
```

**4. 同步一个静态方法**

```java
public synchronized static void fun() {
    // ...
}
```

作用于整个类。等同于锁类

#### 2.6.2 ReentrantLock

ReentrantLock 是 java.util.concurrent(J.U.C)包中的锁。

```java
public class LockExample {

    private Lock lock = new ReentrantLock();

    public void func() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        } finally {
            lock.unlock(); // 确保释放锁，从而避免发生死锁。
        }
    }
}
```

```java
public static void main(String[] args) {
    LockExample lockExample = new LockExample();
    ExecutorService executorService = Executors.newCachedThreadPool();
    executorService.execute(() -> lockExample.func());
    executorService.execute(() -> lockExample.func());
}
```

```
0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9
```

#### 2.6.3 比较

**1. 锁的实现**

synchronized 是 JVM 实现的，而 ReentrantLock 是 JDK 实现的。

**2. 性能**

新版本 Java 对 synchronized 进行了很多优化，例如自旋锁等，synchronized 与 ReentrantLock 大致相同。

**3. 等待可中断**

当持有锁的线程长期不释放锁的时候，正在等待的线程可以选择放弃等待，改为处理其他事情。

ReentrantLock 可中断，而 synchronized 不行。

**4. 公平锁**

公平锁是指多个线程在等待同一个锁时，必须按照申请锁的时间顺序来依次获得锁。

synchronized 中的锁是非公平的，ReentrantLock 默认情况下也是非公平的，但是也可以是公平的。

**5. 锁绑定多个条件**

一个 ReentrantLock 可以同时绑定多个 Condition 对象。

#### 2.6.4 使用选择

除非需要使用 ReentrantLock 的高级功能，否则优先使用 synchronized。这是因为 synchronized 是 JVM 实现的一种锁机制，JVM 原生地支持它，而 ReentrantLock 不是所有的 JDK 版本都支持。并且使用 synchronized 不用担心没有释放锁而导致死锁问题，因为 JVM 会确保锁的释放。

### 2.7 线程协作

当多个线程可以一起工作去解决某个问题时，如果某些部分必须在其它部分之前完成，那么就需要对线程进行协调。

#### 2.7.1 join()

在线程中调用另一个线程的 join() 方法，会将当前线程挂起，而不是忙等待，直到目标线程结束。

对于以下代码，虽然 b 线程先启动，但是因为在 b 线程中调用了 a 线程的 join() 方法，b 线程会等待 a 线程结束才继续执行，因此最后能够保证 a 线程的输出先于 b 线程的输出。

```java
public class JoinExample {

    private class A extends Thread {
        @Override
        public void run() {
            System.out.println("A");
        }
    }

    private class B extends Thread {

        private A a;

        B(A a) {
            this.a = a;
        }

        @Override
        public void run() {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }

    public void test() {
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
    }
}
```

```java
public static void main(String[] args) {
    JoinExample example = new JoinExample();
    example.test();
}
```

```
A
B
```

