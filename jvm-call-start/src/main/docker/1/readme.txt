1. top 之后，输入大写的P。按照CPU占用率排序，找到最大的进程ID

  PID USER      PR  NI    VIRT    RES    SHR S  %CPU %MEM     TIME+ COMMAND
    1 root      20   0 2987092 297188  16856 S 100.2 14.5  14:58.25 java
   26 root      20   0   21948   3532   3028 S   0.0  0.2   0:00.06 bash
  138 root      20   0   23632   2688   2332 R   0.0  0.1   0:00.00 top



2. top -Hp 1  。 找到此进程中(1)的线程占用。找到线程ID 33

  PID USER      PR  NI    VIRT    RES    SHR S %CPU %MEM     TIME+ COMMAND
   33 root      20   0 2987092 297188  16856 R 99.9 14.5  13:53.38 java
    1 root      20   0 2987092 297188  16856 S  0.0 14.5   0:00.03 java
    5 root      20   0 2987092 297188  16856 S  0.0 14.5   0:00.16 java
    6 root      20   0 2987092 297188  16856 S  0.0 14.5   0:00.09 java
    7 root      20   0 2987092 297188  16856 S  0.0 14.5   0:00.07 java

3. printf "0x%x\n" 33  。  将10进制的33转化成16进制0x21

4. jstack 1 | grep 0x21 -A10  。利用jstack查询线程状态，找到33这个线程ID，打印一下他的下面10行

"http-nio-8080-exec-3" #23 daemon prio=5 os_prio=0 tid=0x00007fd43898c800 nid=0x21 runnable [0x00007fd46ad74000]
   java.lang.Thread.State: RUNNABLE
	at com.shuqi.controller.HelloController.test1(HelloController.java:24)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:221)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:136)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:110)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:832)