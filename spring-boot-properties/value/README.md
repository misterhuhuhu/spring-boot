##

字符串默认值
```
@Value("${some.key:my default value}")
private String stringWithDefaultValue;
```
基本数据
```
@Value("${some.key:true}")
private boolean booleanWithDefaultValue;
@Value("${some.key:42}")
private int intWithDefaultValue;

```

数组
``` 
@Value("${some.key:one,two,three}")
private String[] stringArrayWithDefaults;

@Value("${some.key:1,2,3}")
private int[] intArrayWithDefaults;
```
SpEL
``` 
@Value("#{systemProperties['some.key'] ?: 'my default system property value'}")
private String spelWithDefaultValue;
```