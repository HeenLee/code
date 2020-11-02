package com.study;
/**
 * try{可能出现问题的代码}
 * catch(异常名 变量){}
 * finally{释放资源}
 * 编译期异常：必须进行处理，否则编译不通过
 * 运行时异常：需要修正代码
 * throws 抛出
 * 		有些时候，我们是可以对异常进行处理的，但是又有些时候，我们根本就没有权限去处理某个异常。
		为了解决出错问题，Java针对这种情况，就提供了另一种处理方案：抛出。
		格式：
		throws 异常类名
		注意：这个格式必须跟在方法的括号后面。
		    尽量不要在main方法上抛出异常。
		小结：
		编译期异常抛出，将来调用者必须处理。
		运行期异常抛出，将来调用可以不用处理
3、throw:如果出现了异常情况，我们可以把该异常抛出，这个时候的抛出的应该是异常的对象。
 throws和throw的区别(面试题)
 throws
        用在方法声明后面，跟的是异常类名
        可以跟多个异常类名，用逗号隔开
        表示抛出异常，由该方法的调用者来处理
        throws表示出现异常的一种可能性，并不一定会发生这些异常
 throw
        用在方法体内，跟的是异常对象名
        只能抛出一个异常对象名
        表示抛出异常，由方法体内的语句处理
        throw则是抛出了异常，执行throw则一定抛出了某种异常
finally:被finally控制的语句体一定会执行
注意：如果在执行到finally之前jvm退出了，就不能执行了。用于释放资源。

finally中的return 会覆盖 try 或者catch中的返回值。

finally中的return会抑制（消灭）前面try或者catch块中的异常

finally中的异常会覆盖（消灭）前面try或者catch中的异常
面试题：
1、final,finally和finalize的区别
 final：最终的意思，可以修饰类，成员变量，成员方法
        修饰类，类不能被继承
        修饰变量，变量是常量
        修饰方法，方法不能被重写
 finally：是异常处理的一部分，用于释放资源。
         一般来说，代码肯定会执行，特殊情况：在执行到finally之前jvm退出了
 finalize：是Object类的一个方法，用于垃圾回收
 2、如果catch里面有return语句，请问finally里面的代码还会执行吗?
    如果会，请问是在return前，还是return后。
   会。前。准确的说，应该是在中间。

1、子类重写父类方法时，子类的方法必须抛出相同的异常或父类异常的子类。
2、如果父类抛出了多个异常,子类重写父类时,只能抛出相同的异常或者是他的子类,子类不能抛出父类没有的异常
3、如果被重写的方法没有异常抛出,那么子类的方法绝对不可以抛出异常,如果子类方法内有异常发生,那么子类只能try,不能throws
 */
public class TestException {

	public static void main(String[] args) {
		int num = num(10,0);
		System.out.println(num);
		
	}
	
	public static int num(int a,int b){
		int value = 10;
		try {
			value = a/b;
			System.out.println(value);
		} catch (Exception e) {
			return 0;
		}
		finally{
			System.out.println("c");
		}
		return value;
	}
}
