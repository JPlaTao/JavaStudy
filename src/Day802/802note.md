### 第三章 程序流程控制

即对程序执行流程的控制

其一般分为三种：顺序结构、分支结构、循环结构

- 顺序结构：不加任何控制，代码从main方法开始自上而下执行
- 分支结构：就是根据条件判断是true还是false，有选择性的执行哪些代码。在 Java语言中提供了两个格式if 、 switch
- 循环结构：就是控制某一段代码重复执行。在Java语言中提供了三种格式， for、while、do-while还有1.5新增的for-each循环，可以迭代（遍历）数组



#### 分支

##### if分支

if它的作用，是用于对条件进行判断，判断的结果只可能有两个值true或者false，然后 根据条件判断的结果来决定执行那段代码。

if分支的格式 接下来，我们来看一看if分支在Java语言中长什么样子呢？在Java中if分支有三种格 式。

**if 第一种形式**

``` java
// 需求：测量用户体温，发现体温高于37度就报警。
double temp = 38;
if (temp > 37) {
System.out.println("这个人体温不正常，快把他抓走");
System.out.println("这个人体温不正常，快把他抓走");
System.out.println("这个人体温不正常，快把他抓走");
}
System.out.println("我是代码的剩余部分");
```



**if 第二种形式**

``` java
// 需求2：发红包，你的钱包余额是99元，现在要发出90元
// 如果钱够触发发红包的动作，如果钱不够，则提示：余额不足。
public static void main(String[] args) {
	// 需求2：发红包，你的钱包余额是99元，现在要发出90元
	// 如果钱够触发发红包的动作，如果钱不够，则提示：余额不足。
	System.out.println("我要开始发红包了");
	double balance = 89;
	if (balance > 90) {
		balance -= 90;
		System.out.println("你的余额是" + balance);
    } else {
		System.out.println("余额不足");
	}
		System.out.println("继续执行main方法");
}
```



**if 第三种形式**

``` java
// 需求3：某个公司有一个绩效系统，根据员工的打分输出对应的绩效级别。[0,60) D
[60,80) C [80,90) B [90,100] A
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("请输入员工打分成绩");
	double score = sc.nextDouble();
// 需求3：某个公司有一个绩效系统，根据员工的打分输出对应的绩效级别。
[0,60) D [60,80) C [80,90) B [90,100] A
		if (score >= 0 && score < 60) {
			System.out.println("员工绩效级别：D");
		} else if (score < 80) {
			System.out.println("员工绩效级别：C");
		} else if (score < 90) {
			System.out.println("员工绩效级别：B");
		} else if (score <= 100) {
			System.out.println("员工绩效级别：A");
		} else {
			System.out.println("你输入的成绩不合理");
		}
System.out.println("继续执行main方法");
}
```



##### switch分支

switch 分支的作用，是通过比较值来决定执行哪条分支代码。

案例演示：

``` java
/*
需求：做个电子备忘录，在控制台分别输出周一到周五的工作安排
周一：埋头苦干，解决bug
周二： 请求大牛程序员帮忙
周三：今晚啤酒、龙虾、小烧烤
周四：主动帮助新来的女程序解决bug
周五：今晚吃鸡
周六：与王婆介绍的小芳相亲
周日：郁郁寡欢、准备上班。
*/
String week = "周三";
switch (week){
	case "周一":
		System.out.println("埋头苦干，解决bug");
		break;
	case "周二":
		System.out.println("请求大牛程序员帮忙");
		break;
	case "周三":
		System.out.println("今晚啤酒、龙虾、小烧烤");
		break;
	case "周四":
		System.out.println("主动帮助新来的女程序解决bug");
		break;
	case "周五":
		System.out.println("今晚吃鸡");
		break;
    case "周六":
   		System.out.println("与王婆介绍的小芳相亲");
    	break;
    case "周日":
    	System.out.println("郁郁寡欢、准备上班");
    	break;
    default:
    	System.out.println("您输入的星期信息不存在~~~");
    }

```

##### switch注意事项

- 表达式类型只能是byte、short、int、char；JDK5开始支持枚举，JDK7开始支持 String，不支持double、float等
- case给出的值不允许重复，且只能是字面量，不能是变量。
- 正常使用switch的时候，不要忘记写break，否则会出现穿透现象。



**case后面的值，只能是字面量不能是变量**

``` java
int i = 20;
int d = 20;
switch(i) {
	case 10:
		// 省略部分代码
		break;
	case d:
		// 省略部分代码
		break;
}

```



**case穿透现象**

当switch语句中没有遇到break，就会直接穿透到下一个case语句执行，直到遇到break 为止。

``` java
String week = "周二";
    switch(week) {
    	case "周一" :
    		System.out.println("埋头苦干，解决bug");
    	break;
    case "周二" :
    	System.out.println("忙忙碌碌不知道在干什么");
    case "周三" :
    	System.out.println("忙忙碌碌不知道在干什么");
    case "周四" :
    	System.out.println("请求大佬程序员帮忙");
   		break;
    case "周五" :
    	System.out.println("自己整理代码");
    	break;
     case "周六" :
		System.out.println("逛街");
	case "周日" :
		System.out.println("打游戏");
		break;
	default:
		System.out.println("你输入的星期信息不存在");
}
```



##### switch分支新特性

**特性1：箭头表达式**

``` java
public static void main(String[] args) {
	// 先输入年份，在输入一个月份，返回这个月多少天
	// 31 30 29 28 31 1,3,5,7,8,10,12 30 4, 6 , 9, 11 2 闰年29天 平年 28天
	Scanner sc = new Scanner(System.in);
	System.out.println("请输入一个年份：");
	int year = sc.nextInt();
	System.out.println("请输入一个月份：");
	int month = sc.nextInt();
        // int temp = 12;
        // switch 新特性 -> 箭头表达式
        int days = 0;
		switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> days = 31;
            case 4, 6, 9, 11 -> days = 30;
            case 2 -> {
            // 判断 year 是否是闰年
                if (year % 4 == 0 && year % 100 != 0 || year % 400 ==0) {
                    days = 29;
                } else {
                    days = 28;
                }
        }
	default -> days = -1;
	}
	if (days == -1) {
		System.out.println("输入的月份不正确");
	} else {
		System.out.println("这个月" + days + "天");
	}
	// System.out.println(days == -1 ? "输入的月份不正确" :
	"这个月" + days + "天");
}
```



**特性2：yield**

``` java
public static void main(String[] args) {
	// 先输入年份，在输入一个月份，返回这个月多少天
	// 31 30 29 28 31 1,3,5,7,8,10,12 30 4, 6 , 9, 11 2 闰年29天 平年 28天
	Scanner sc = new Scanner(System.in);
    System.out.println("请输入一个年份：");
    int year = sc.nextInt();
    System.out.println("请输入一个月份：");
    int month = sc.nextInt();
        // int temp = 12;
        // switch 新特性 yield 在 {} 中返回某个值给变量
        // int days = 0;
        int days = switch (month) {
    	// case temp: 错误使用
    		case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> {
            // 判断 year 是否是闰年
            if (year % 4 == 0 && year % 100 != 0 || year % 400 ==0) {
    			yield 29;
    			} else {
    			yield 28;
    			}
    	}
    	default -> -1;
};
    if (days == -1) {
    	System.out.println("输入的月份不正确");
    	} else {
    	System.out.println("这个月" + days + "天");
    }
    // System.out.println(days == -1 ? "输入的月份不正确" :
    "这个月" + days + "天");
    }

```



**if 、switch如何选择**

``` java
- 如果是对一个范围进行判断，建议使用if分支结构
- 如果是与一个一个的值比较的时候，建议使用switch分支结构
```

