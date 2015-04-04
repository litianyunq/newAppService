package com.lty.newApp;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.CloseFuture;
import org.apache.mina.core.future.IoFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerMessageHandler extends IoHandlerAdapter { 
 
private final static Logger log = LoggerFactory.getLogger(ServerMessageHandler.class);
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        log.info(df.format(new Date())+"服务器发生异常： {}", cause.getMessage());
    }
 
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        log.info(df.format(new Date())+"服务器接收到数据： {}", message);
        String content = message.toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String datetime = sdf.format(new Date());
        
        log.info("转发 messageReceived: " + datetime + "\t" + content);
        
        JSONObject json=new JSONObject(content); 
        JSONObject returnMessage=new JSONObject();
        if(json.get(Constants.KEY_TRANS_CODE).equals(Constants.ACTION_TRANS_CODE_201)){//登陆
        	returnMessage.put(Constants.KEY_TRANS_CODE, Constants.ACTION_TRANS_CODE_201);//交易码
        	returnMessage.put(Constants.KEY_TRANS_TYPE, Constants.ACTION_RESPONSE);//交易类型RESPONSE
        	returnMessage.put(Constants.KEY_RETURN_CODE, Constants.ACTION_RETURN_CODE_0);//响应码 0 成功
        	returnMessage.put(Constants.KEY_RETURN_MESSAGE, json.get(Constants.KEY_MOBILE_NUMBER)+"此用户登陆成功,token:"+"123123");//TOKEN
        	returnMessage.put(Constants.KEY_TOKEN, "123123");//TOKEN
        }else if(json.get(Constants.KEY_TRANS_CODE).equals(Constants.ACTION_TRANS_CODE_801)){
        	
        	returnMessage.put(Constants.KEY_RETURN_CODE, Constants.ACTION_TRANS_CODE_801);//交易码
        	returnMessage.put(Constants.KEY_TRANS_TYPE, Constants.ACTION_RESPONSE);//交易类型RESPONSE
        	returnMessage.put(Constants.KEY_RETURN_CODE, Constants.ACTION_RETURN_CODE_0);//响应码 0 成功
        	returnMessage.put(Constants.KEY_RETURN_MESSAGE, json.get(Constants.KEY_MOBILE_NUMBER)+"此用户获取主页信息成功");

        	JSONObject head=new JSONObject();
        	head.put(Constants.KEY_USER_NAME, "无皮包子");//对应oneday发表用户
        	head.put(Constants.KEY_USER_CSID, "cus0000000001");//对应oneday发表用户
        	head.put(Constants.KEY_USER_HEAD, "http://litianyunq.nat123.net:5333/TestServer/lz_one_01.png");//对应oneday发表用户
        	head.put(Constants.KEY_ONEDAY_ID, "000001");//对应oneday流水ID
        	head.put(Constants.KEY_ONEDAY_TODAY_ID, "00");//对应oneday当日流水ID
        	head.put(Constants.KEY_ONEDAY_TIME, "8:24");//对应oneday发表时间
        	head.put(Constants.KEY_ONEDAY_PLACE, "北京");//对应oneday发表城市
        	head.put(Constants.KEY_ONEDAY_DATE, "2015-04-03");//对应oneday发表日期
        	head.put(Constants.KEY_ONEDAY_TITLE, "主题:创业ing");//对应oneday发表标题
        	head.put(Constants.KEY_ONEDAY_NUM, "第100期");//对应oneday发表期数
        	head.put(Constants.KEY_ONEDAY_PRAISE_NUM, "1045");//对应oneday获得赞总数
        	head.put(Constants.KEY_ONEDAY_DISCUSSION_NUM, "500");//对应oneday获得讨论总数
        	head.put(Constants.KEY_ONEDAY_CONTENT, "&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;我们吃饭，接受食物的温度；我们独自吃饭，面对最柔软的自己。爱与食物，塑造了世间万千-饮食男女。《中国人的一天》光棍节特刊");//对应oneday内容
        	head.put(Constants.KEY_ONEDAY_IMG, "http://litianyunq.nat123.net:5333/TestServer/lz_one_01.png");//对应oneday获得讨论总数
        	JSONObject body01=new JSONObject();
        	body01.put(Constants.KEY_ONEDAY_ID, "000002");//对应oneday流水ID
        	body01.put(Constants.KEY_ONEDAY_TODAY_ID, "01");//对应oneday当日流水ID
        	body01.put(Constants.KEY_ONEDAY_TIME, "9:24");//对应oneday发表时间
        	body01.put(Constants.KEY_ONEDAY_PRAISE_NUM, "80");//对应oneday获得赞总数
        	body01.put(Constants.KEY_ONEDAY_DISCUSSION_NUM, "40");//对应oneday获得讨论总数
        	body01.put(Constants.KEY_ONEDAY_CONTENT, "&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;我们吃饭，接受食物的温度；我们独自吃饭，面对最柔软的自己。爱与食物，塑造了世间万千-饮食男女。《中国人的一天》光棍节特刊");//对应oneday内容
        	body01.put(Constants.KEY_ONEDAY_IMG, "http://litianyunq.nat123.net:5333/TestServer/lz_one_01.png");//对应oneday获得讨论总数
        	JSONObject body02=new JSONObject();
        	body02.put(Constants.KEY_ONEDAY_ID, "000003");//对应oneday流水ID
        	body02.put(Constants.KEY_ONEDAY_TODAY_ID, "02");//对应oneday当日流水ID
        	body02.put(Constants.KEY_ONEDAY_TIME, "10:24");//对应oneday发表时间
        	body02.put(Constants.KEY_ONEDAY_PRAISE_NUM, "60");//对应oneday获得赞总数
        	body02.put(Constants.KEY_ONEDAY_DISCUSSION_NUM, "20");//对应oneday获得讨论总数
        	body02.put(Constants.KEY_ONEDAY_CONTENT, "&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;我们吃饭，接受食物的温度；我们独自吃饭，面对最柔软的自己。爱与食物，塑造了世间万千-饮食男女。《中国人的一天》光棍节特刊");//对应oneday内容
        	body02.put(Constants.KEY_ONEDAY_IMG, "http://litianyunq.nat123.net:5333/TestServer/lz_one_01.png");//对应oneday获得讨论总数
        	JSONObject body03=new JSONObject();
        	body03.put(Constants.KEY_ONEDAY_ID, "000004");//对应oneday流水ID
        	body03.put(Constants.KEY_ONEDAY_TODAY_ID, "03");//对应oneday当日流水ID
        	body03.put(Constants.KEY_ONEDAY_TIME, "10:24");//对应oneday发表时间
        	body03.put(Constants.KEY_ONEDAY_PRAISE_NUM, "60");//对应oneday获得赞总数
        	body03.put(Constants.KEY_ONEDAY_DISCUSSION_NUM, "20");//对应oneday获得讨论总数
        	body03.put(Constants.KEY_ONEDAY_CONTENT, "&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;我们吃饭，接受食物的温度；我们独自吃饭，面对最柔软的自己。爱与食物，塑造了世间万千-饮食男女。《中国人的一天》光棍节特刊");//对应oneday内容
        	body03.put(Constants.KEY_ONEDAY_IMG, "http://litianyunq.nat123.net:5333/TestServer/lz_one_01.png");//对应oneday获得讨论总数
        	returnMessage.put(Constants.KEY_ONEDAY_HEAD_INFO, head.toString());
        	JSONArray jsaArray=new JSONArray();
        	jsaArray.put(body01.toString());
        	jsaArray.put(body02.toString());
        	jsaArray.put(body03.toString());
        	returnMessage.put(Constants.KEY_ONEDAY_BODY_INFO, jsaArray.toString());
        	//litianyun
        }else {
        	returnMessage.put(Constants.KEY_RETURN_CODE, Constants.ACTION_RETURN_CODE_11);//交易码
        	returnMessage.put(Constants.KEY_RETURN_MESSAGE, Constants.ACTION_RETURN_MESSAGE_11);//交易码
        }
        DecimalFormat df2 = new DecimalFormat("0000");
    	String a=df2.format(returnMessage.toString().length());
        String str=a+returnMessage;
        for(int i =500;i<str.length();){
            session.write(str.substring(0, i));
            str=str.substring(i, str.length());
    	}
        session.write(str.substring(0, str.length()));

        
 //  commit       
//    	DecimalFormat df2 = new DecimalFormat("0000");
//    	String a=df2.format(returnMessage.toString().getBytes().length);
//    	byte bt[]=(a+returnMessage).getBytes();
//    	IoBuffer ioBuffer = IoBuffer.allocate(bt.length);   
//    	//自动收缩
//    	ioBuffer.setAutoShrink(true); 
//    	// 自动扩容  
//    	ioBuffer.setAutoExpand(true);
//    	ioBuffer.put(bt, 0, bt.length);   
//    	ioBuffer.flip();  
//    	ioBuffer.mark();
//    	for(int i =500;i<ioBuffer.remaining();){
//    		byte[] sizeBytes = new byte[i];
//    		ioBuffer.get(sizeBytes);
//    		System.out.println(new String(sizeBytes,"GBK"));
//            session.write(sizeBytes);
//    	}
//    	byte[] sizeBytes = new byte[ioBuffer.remaining()];
//    	ioBuffer.get(sizeBytes);
//    	System.out.println(new String(sizeBytes,"GBK"));
//    	session.write(sizeBytes);
        // 拿到所有的客户端Session
//        Collection<IoSession> sessions = session.getService().getManagedSessions().values();
//        // 向所有客户端发送数据
//        for (IoSession sess : sessions) {
//            sess.write(datetime + "\t" + content);
//        }
    }
 
    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        log.info(df.format(new Date())+"服务器发送消息： {}", message);
    }
 
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        log.info(df.format(new Date())+"关闭当前session：{}#{}", session.getId(), session.getRemoteAddress());
        
        CloseFuture closeFuture = session.close(true);
        closeFuture.addListener(new IoFutureListener<IoFuture>() {
            @Override
			public void operationComplete(IoFuture future) {
                if (future instanceof CloseFuture) {
                    ((CloseFuture) future).setClosed();
                    log.info("sessionClosed CloseFuture setClosed-->{},", future.getSession().getId());
                }
            }
        });
    }
 
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        log.info(df.format(new Date())+"创建一个新连接：{}", session.getRemoteAddress());
//        session.write("welcome to the chat room !");
    }
 
    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        log.info(df.format(new Date())+"当前连接{}处于空闲状态：{}", session.getRemoteAddress(), status);
    }
 
    @Override
    public void sessionOpened(IoSession session) throws Exception {
        log.info(df.format(new Date())+"打开一个session：{}#{}", session.getId(), session.getBothIdleCount());
    }
    
    public static IoBuffer byteToIoBuffer(byte [] bt,int length)   
    {   
      
           IoBuffer ioBuffer = IoBuffer.allocate(length);   
           ioBuffer.put(bt, 0, length);   
           ioBuffer.flip();   
           return ioBuffer;   
    }   
    
    public static String byteToString(byte [] b)   
    {   
           StringBuffer stringBuffer = new StringBuffer();   
           for (int i = 0; i < b.length; i++)   
           {   
               stringBuffer.append((char) b [i]);   
           }   
           return stringBuffer.toString();   
    }   
    
    public static byte [] ioBufferToByte(IoBuffer message)   
    {   
//          if (!(message instanceof IoBuffer))   
//          {   
//              return null;   
//          }   
          byte[] b = new byte[message.limit()];   
          message.get(b);   
          return b;   
    }   
} 