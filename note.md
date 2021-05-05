**导入架包**
```java
<dependencies>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.3.4</version>
    </dependency>
```
网址：https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-setter-injection
**IOC推导**
```text
利用set进行动态实现值的注入 程序由主动性变为被动接受的对象
控制层主动权被用户掌握
控制反转IOC 是一种设计思想，DI（依赖注入）是实现IOC的一种方法。
没有IOC的程序中，使用面向对象编程，对象的创建与对象间的依赖关系完全编码在代码中，对象的创建由程序自己控制
控制反转后将对象的创建转移给第三方，控制反转就是获得依赖对象的方式反转了。
```
**Ioc工作**
```text
. Spring 容器在初始化时先读取配置文件，根据配置文件或元数据创建与组织对象存入容器中，程序使用时再从IOC容器中取出对象
. 采用XML方式配置Bean的时候，Bean的定义信息是和实现分离的，而采用注解的方式可以把两者合为一体，Bean的定义信息直接以注解的形式定义在实现类中，从而达到了零配置的目的。
. 控制反转是一种通过描述（XML或注解）并通过第三方去生产或获取特定对象的方式。在Spring中实现控制反转的是IoC容器，其实现方法是依赖注入（Dependency Injection，DI）。

```
**beans配置文件**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">
</beans>
```
**Hello**

```text
Hello对象是谁创建的？
Hello对象是由Spring创建的。
Hello对象的属性是怎么设置的？
Hello对象的属性是由Spring容器设置的。
这个过程就叫控制反转,对象主动权在第三方（虽然第三方是你引入的）
```
```xml
<!--使用Spring来创建对象，在Spring这些都称为Bean
    类型 变量名 = new 类型();
    Hello hello = new Hello();
     bean=对象
    id = 变量名
    class = new的对象
    property 相当于给对象中的属性设置一个值！
        -->
```
```text
控制：谁来控制对象的创建，传统应用程序的对象是由程序本身控制创建的，使用Spring后，对象是由Spring来创建的。

反转：程序本身不创建对象，而变成被动的接收对象。

依赖注入：就是利用set方法来进行注入的。

IOC是一种编程思想，由主动的编程变成被动的接收。
获取Spring的上下文对象
. ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
. 不用在程序中去改动,实现不同的操作，只需要在xml配置文件中进行修改.
. IOC：对象由Spring来创建，管理，装配！
. ref:引用Spring容器中创建好的对象 value：具体的值基本数据类型 不同对象ref进行修改即可
```
**IOC创建对象的方式**
使用无参构造创建对象，默认.
在配置文件加载的时候，容器中管理的对象就已经初始化了,即创建Bean时已经创建了对象
若要使用有参构造
```xml
<!--有参构造方式-->
    <!--第一种方式：下标赋值    -->
    <bean id="user" class="com.pn.entity.User">
        <constructor-arg index="0" value="下标 index Java"/>
    </bean>
    <!--第二种方式：通过类型的创建，不建议使用    -->
    <bean id="user" class="com.pn.entity.User">
        <constructor-arg type="java.lang.String" value="String 类型"/>
    </bean>
    <!--第三种方式：直接通过参数名来设置    -->
    <bean id="user" class="com.pn.entity.User">
        <constructor-arg name="name" value="参数名"/>
    </bean>
```
p命名和c命名空间不能直接使用，需要导入xml约束！
```text
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c"
```
**bean作用域** 
单例模式（Spring默认机制）
原型模式：每次从容器中get的时候，都会产生一个新对象
```xml
<bean id="user2" class="com.pn.entity.User" c:name="单例" c:age="22" scope="singleton"/>

<bean id="user2" class="com.pn.entity.User" c:name="新对象" c:age="22" scope="prototype"/>

```
**在Spring中有三种装配的方式：**
在xml中显式的配置；
在java中显式配置；
隐式的自动装配bean【重要】

```xml
 <!--
          byName：会自动在容器上下文中查找，和自己对象set方法后面的值对应的bean id！
          setDog找Dog
              -->
    <!--
        byType：会自动在容器上下文中查找，和自己对象属性类型相同的bean！可以不用写id
         <bean  class="com.pn.entity.Cat"/>
            -->
```
**自动注解**
约束： context
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
	        https://www.springframework.org/schema/beans/spring-beans.xsd
	        http://www.springframework.org/schema/context
	        https://www.springframework.org/schema/context/spring-context.xsd">
		
		<!--开启注解的支持    -->
        <context:annotation-config/>
</beans>

```
```xml
@Autowired

直接在属性上使用即可！也可以在set方法上使用！

使用Autowired我们就可以不用编写set方法了，且符合ByType！
        <!--
                 byName：会自动在容器上下文中查找，和自己对象set方法后面的值对应的bean id！
                 setDog找 Dog 后面this.dog = dog;所以应是小写dog
                     -->
         使用@Autowired与id无关与class有关
        <!--
                byType：会自动在容器上下文中查找，和自己对象属性类型相同的bean！可以不用写id
                 <bean  class="com.pn.entity.Cat"/>
                    -->
```
```text
. @Nullable 字段标记了了这个注解，说明这个字段可以为null;
. 如果显式定义了Autowired的required属性为false，说明这个对象可以为null，否则不允许为空
. @Autowired(required = false)
. 如果@Autowired自动装配的环境比较复杂，自动装配无法通过一个注解【@Autowired】可以不用编写Set方法
  我们可以使用@Qualifier(value = “xxx”)去配置@Autowired的使用，指定一个唯一的bean对象注入
        
        
 @Resource和@Autowired的区别：

. 都是用来自动装配的，都可以放在属性字段上
. @Autowired通过byType的方式实现，而且必须要求这个对象存在！【常用】
. @Resource默认通过byName的方式实现，如果找不到名字，则通过byType实现！如果两个都找不到的情况下，就报错！【常用】
. 执行顺序不同：@Autowired通过byType的方式实现。

```
**@Component**
组件放在类上 说明这个类被spring管理了，就是bean
有几个衍生注解，我们在web开发中，会按照mvc三层架构分层！
```text
dao 【@Repository】
service 【@Service】
controller 【@Controller】
这四个注解功能都是一样的，都是代表将某个类注册到Spring中，装配Bean
```
```text
- @Autowired：自动装配通过类型，名字。如果Autowired不能唯一自动装配上属性，则需要通过@Qualifier(value = "xxx")去配置。
- @Nullable 字段标记了了这个注解，说明这个字段可以为null;
- @Resource：自动装配通过名字，类型。

xml与注解：
xml更加万能，适用于任何场合！维护简单方便
注解不是自己类使用不了，维护复杂！
xml与注解最佳实践：
xml用来管理bean；
注解只负责完成属性的注入；
我们在使用的过程中，只需要注意一个问题：必须让注解生效，就需要开启注解的支持
```
```xml
    <!--指定要扫描的包，这个包下的注解就会生效-->
    <context:component-scan base-package="com.xx"/>
    <!--开启注解的支持    -->
    <context:annotation-config/>

```
**使用Java的方式配置Spring**
spring-07-appconfig
**代理模式**
```text
静态代理
角色分析：
抽象角色：一般会使用接口或者抽象类来解决
真实角色：被代理的角色
代理角色：代理真实角色，代理真实角色后，我们一般会做一些附属操作
客户：访问代理对象的人！

代理模式的好处：
可以使真实角色的操作更加纯粹！不用去关注一些公共的业务
公共角色就交给代理角色！实现了业务的分工！
公共业务发生扩展的时候，方便集中管理！
缺点：
一个真实角色就会产生一个代理角色，代码量会翻倍，开发效率会变低~
```
**动态代理**
```text
动态代理和静态代理角色一样
动态代理的代理类是动态生成的，不是我们直接写好的！
动态代理分为两大类：基于接口的动态代理，基于类的动态代理
基于接口 — JDK动态代理【我们在这里使用】
基于类：cglib
java字节码实现：javassist
需要了解两个类：Proxy：代理；InvocationHandler：调用处理程序。


动态代理的好处：
可以使真实角色的操作更加纯粹！不用去关注一些公共的业务
公共角色就交给代理角色！实现了业务的分工！
公共业务发生扩展的时候，方便集中管理！
一个动态代理类代理的是一个接口，一般就是对应的一类业务
一个动态代理类可以代理多个类，只要是实现了同一个接口即可！

```
**AOP在不改变原有代码的情况下，去增加新的功能**
```xml
<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.4</version>
</dependency>

```
**整合Mybatis**
```text
导入相关jar包

junit
mybatis
mysql数据库
spring相关
aop织入器
mybatis-spring整合包【重点】在此还导入了lombok包。
配置Maven静态资源过滤问题！

```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>Spring</artifactId>
        <groupId>org.example</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>Spring-10-mybatis</artifactId>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>
<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13</version>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.47</version>
    </dependency>
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.2</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.3.4</version>
    </dependency>
<!--    Spring连接数据库需要jdbc-->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>5.3.6</version>
    </dependency>
    <dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjweaver</artifactId>
        <version>1.9.4</version>
    </dependency>
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>2.0.2</version>
    </dependency>
</dependencies>
</project>
```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>Spring</artifactId>
        <groupId>org.example</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>Spring-10-mybatis</artifactId>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.47</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.2</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.3.4</version>
        </dependency>
        <!--    Spring连接数据库需要jdbc-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.3.6</version>
        </dependency>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.4</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.2</version>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.16</version>
        </dependency>
    </dependencies>
</project>


```
**MyBatis-Spring** 
会帮助你将 MyBatis 代码无缝地整合到 Spring 中。
文档链接：http://mybatis.org/spring/zh/index.html
**Spring中的事务管理**
1. 使用Spring管理事务 tx
```xml
xmlns:tx="http://www.springframework.org/schema/tx"

http://www.springframework.org/schema/tx
http://www.springframework.org/schema/tx/spring-tx.xsd">
```

2. JDBC事务
```xml
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>
```

3. 配置好事务管理器后我们需要去配置事务的通知

```xml
 <!--结合AOP实现事务的织入-->
    <!--配置事务通知-->
<tx:advice id="txAdvice" transaction-manager="transactionManager">
   <!--给那些方法配置事务-->
   <!--配置事务的传播特性： new -->
<tx:attributes>
<tx:method name="add" propagation="REQUIRED"/>
<tx:method name="delete" propagation="REQUIRED"/>
<tx:method name="update" propagation="REQUIRED"/>
<tx:method name="query" read-only="true"/>
<tx:method name="*" propagation="REQUIRED"/>
</tx:attributes>
</tx:advice>
```

4. 配置AOP，导入aop的头文件

 ```xml
<!--配置事务切入-->
<aop:config>
<aop:pointcut id="txPointCut" expression="execution(* com.kuang.mapper.*.*(..))"/>
<aop:advisor advice-ref="txAdvice" pointcut-ref="txPointCut"/>
</aop:config>
```

5. 删掉刚才插入的数据，再次测试！

  
  