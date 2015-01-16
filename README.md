# A very strange "circle reference" warning

If you run `my.Main`, you will see the output is like:

```
Jan 17, 2015 1:36:28 AM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@41906a77: startup date [Sat Jan 17 01:36:28 CST 2015]; root of context hierarchy
Jan 17, 2015 1:36:28 AM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [applicationContext.xml]
Jan 17, 2015 1:36:29 AM org.springframework.beans.factory.support.DefaultListableBeanFactory getTypeForFactoryBean
WARNING: Bean creation exception on FactoryBean type check: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'addResponseInterceptor' defined in class path resource [applicationContext.xml]: Cannot resolve reference to bean 'httpClient' while setting bean property 'targetObject'; nested exception is org.springframework.beans.factory.BeanCurrentlyInCreationException: Error creating bean with name 'httpClient': Requested bean is currently in creation: Is there an unresolvable circular reference?
org.apache.http.impl.client.DefaultHttpClient@40a4337a
```

It reports there may be an `unresolvable circular reference`. I tried hard, but not found the reason.

But I did have some trick ways to avoid it:

1. rename `myweb.services` to `myweb.conf` or something, it will go
2. but, if rename it to `myweb.sss` or something, it's still there
3. in `applicationContext.xml`, replace `MethodInvokingFactoryBean` with `MethodInvokingBean`, it will go
4. move `CacheConfig` to package `myweb`, it will go

You can see it's really tricky that the package name of `CacheConfig` matters!

I don't know why.
