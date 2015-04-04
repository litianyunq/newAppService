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
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        log.info(df.format(new Date())+"�����������쳣�� {}", cause.getMessage());
    }
 
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        log.info(df.format(new Date())+"���������յ����ݣ� {}", message);
        String content = message.toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String datetime = sdf.format(new Date());
        
        log.info("ת�� messageReceived: " + datetime + "\t" + content);
        
        JSONObject json=new JSONObject(content); 
        JSONObject returnMessage=new JSONObject();
        if(json.get(Constants.KEY_TRANS_CODE).equals(Constants.ACTION_TRANS_CODE_201)){//��½
        	returnMessage.put(Constants.KEY_TRANS_CODE, Constants.ACTION_TRANS_CODE_201);//������
        	returnMessage.put(Constants.KEY_TRANS_TYPE, Constants.ACTION_RESPONSE);//��������RESPONSE
        	returnMessage.put(Constants.KEY_RETURN_CODE, Constants.ACTION_RETURN_CODE_0);//��Ӧ�� 0 �ɹ�
        	returnMessage.put(Constants.KEY_RETURN_MESSAGE, json.get(Constants.KEY_MOBILE_NUMBER)+"���û���½�ɹ�,token:"+"123123");//TOKEN
        	returnMessage.put(Constants.KEY_TOKEN, "123123");//TOKEN
        }else if(json.get(Constants.KEY_TRANS_CODE).equals(Constants.ACTION_TRANS_CODE_801)){
        	
        	returnMessage.put(Constants.KEY_RETURN_CODE, Constants.ACTION_TRANS_CODE_801);//������
        	returnMessage.put(Constants.KEY_TRANS_TYPE, Constants.ACTION_RESPONSE);//��������RESPONSE
        	returnMessage.put(Constants.KEY_RETURN_CODE, Constants.ACTION_RETURN_CODE_0);//��Ӧ�� 0 �ɹ�
        	returnMessage.put(Constants.KEY_RETURN_MESSAGE, json.get(Constants.KEY_MOBILE_NUMBER)+"���û���ȡ��ҳ��Ϣ�ɹ�");

        	JSONObject head=new JSONObject();
        	head.put(Constants.KEY_USER_NAME, "��Ƥ����");//��Ӧoneday�����û�
        	head.put(Constants.KEY_USER_CSID, "cus0000000001");//��Ӧoneday�����û�
        	head.put(Constants.KEY_USER_HEAD, "http://litianyunq.nat123.net:5333/TestServer/lz_one_01.png");//��Ӧoneday�����û�
        	head.put(Constants.KEY_ONEDAY_ID, "000001");//��Ӧoneday��ˮID
        	head.put(Constants.KEY_ONEDAY_TODAY_ID, "00");//��Ӧoneday������ˮID
        	head.put(Constants.KEY_ONEDAY_TIME, "8:24");//��Ӧoneday����ʱ��
        	head.put(Constants.KEY_ONEDAY_PLACE, "����");//��Ӧoneday�������
        	head.put(Constants.KEY_ONEDAY_DATE, "2015-04-03");//��Ӧoneday��������
        	head.put(Constants.KEY_ONEDAY_TITLE, "����:��ҵing");//��Ӧoneday�������
        	head.put(Constants.KEY_ONEDAY_NUM, "��100��");//��Ӧoneday��������
        	head.put(Constants.KEY_ONEDAY_PRAISE_NUM, "1045");//��Ӧoneday���������
        	head.put(Constants.KEY_ONEDAY_DISCUSSION_NUM, "500");//��Ӧoneday�����������
        	head.put(Constants.KEY_ONEDAY_CONTENT, "&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;���ǳԷ�������ʳ����¶ȣ����Ƕ��ԳԷ��������������Լ�������ʳ�������������ǧ-��ʳ��Ů�����й��˵�һ�졷������ؿ�");//��Ӧoneday����
        	head.put(Constants.KEY_ONEDAY_IMG, "http://litianyunq.nat123.net:5333/TestServer/lz_one_01.png");//��Ӧoneday�����������
        	JSONObject body01=new JSONObject();
        	body01.put(Constants.KEY_ONEDAY_ID, "000002");//��Ӧoneday��ˮID
        	body01.put(Constants.KEY_ONEDAY_TODAY_ID, "01");//��Ӧoneday������ˮID
        	body01.put(Constants.KEY_ONEDAY_TIME, "9:24");//��Ӧoneday����ʱ��
        	body01.put(Constants.KEY_ONEDAY_PRAISE_NUM, "80");//��Ӧoneday���������
        	body01.put(Constants.KEY_ONEDAY_DISCUSSION_NUM, "40");//��Ӧoneday�����������
        	body01.put(Constants.KEY_ONEDAY_CONTENT, "&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;���ǳԷ�������ʳ����¶ȣ����Ƕ��ԳԷ��������������Լ�������ʳ�������������ǧ-��ʳ��Ů�����й��˵�һ�졷������ؿ�");//��Ӧoneday����
        	body01.put(Constants.KEY_ONEDAY_IMG, "http://litianyunq.nat123.net:5333/TestServer/lz_one_01.png");//��Ӧoneday�����������
        	JSONObject body02=new JSONObject();
        	body02.put(Constants.KEY_ONEDAY_ID, "000003");//��Ӧoneday��ˮID
        	body02.put(Constants.KEY_ONEDAY_TODAY_ID, "02");//��Ӧoneday������ˮID
        	body02.put(Constants.KEY_ONEDAY_TIME, "10:24");//��Ӧoneday����ʱ��
        	body02.put(Constants.KEY_ONEDAY_PRAISE_NUM, "60");//��Ӧoneday���������
        	body02.put(Constants.KEY_ONEDAY_DISCUSSION_NUM, "20");//��Ӧoneday�����������
        	body02.put(Constants.KEY_ONEDAY_CONTENT, "&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;���ǳԷ�������ʳ����¶ȣ����Ƕ��ԳԷ��������������Լ�������ʳ�������������ǧ-��ʳ��Ů�����й��˵�һ�졷������ؿ�");//��Ӧoneday����
        	body02.put(Constants.KEY_ONEDAY_IMG, "http://litianyunq.nat123.net:5333/TestServer/lz_one_01.png");//��Ӧoneday�����������
        	JSONObject body03=new JSONObject();
        	body03.put(Constants.KEY_ONEDAY_ID, "000004");//��Ӧoneday��ˮID
        	body03.put(Constants.KEY_ONEDAY_TODAY_ID, "03");//��Ӧoneday������ˮID
        	body03.put(Constants.KEY_ONEDAY_TIME, "10:24");//��Ӧoneday����ʱ��
        	body03.put(Constants.KEY_ONEDAY_PRAISE_NUM, "60");//��Ӧoneday���������
        	body03.put(Constants.KEY_ONEDAY_DISCUSSION_NUM, "20");//��Ӧoneday�����������
        	body03.put(Constants.KEY_ONEDAY_CONTENT, "&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;���ǳԷ�������ʳ����¶ȣ����Ƕ��ԳԷ��������������Լ�������ʳ�������������ǧ-��ʳ��Ů�����й��˵�һ�졷������ؿ�");//��Ӧoneday����
        	body03.put(Constants.KEY_ONEDAY_IMG, "http://litianyunq.nat123.net:5333/TestServer/lz_one_01.png");//��Ӧoneday�����������
        	returnMessage.put(Constants.KEY_ONEDAY_HEAD_INFO, head.toString());
        	JSONArray jsaArray=new JSONArray();
        	jsaArray.put(body01.toString());
        	jsaArray.put(body02.toString());
        	jsaArray.put(body03.toString());
        	returnMessage.put(Constants.KEY_ONEDAY_BODY_INFO, jsaArray.toString());
        	//litianyun
        }else {
        	returnMessage.put(Constants.KEY_RETURN_CODE, Constants.ACTION_RETURN_CODE_11);//������
        	returnMessage.put(Constants.KEY_RETURN_MESSAGE, Constants.ACTION_RETURN_MESSAGE_11);//������
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
//    	//�Զ�����
//    	ioBuffer.setAutoShrink(true); 
//    	// �Զ�����  
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
        // �õ����еĿͻ���Session
//        Collection<IoSession> sessions = session.getService().getManagedSessions().values();
//        // �����пͻ��˷�������
//        for (IoSession sess : sessions) {
//            sess.write(datetime + "\t" + content);
//        }
    }
 
    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        log.info(df.format(new Date())+"������������Ϣ�� {}", message);
    }
 
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        log.info(df.format(new Date())+"�رյ�ǰsession��{}#{}", session.getId(), session.getRemoteAddress());
        
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
        log.info(df.format(new Date())+"����һ�������ӣ�{}", session.getRemoteAddress());
//        session.write("welcome to the chat room !");
    }
 
    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        log.info(df.format(new Date())+"��ǰ����{}���ڿ���״̬��{}", session.getRemoteAddress(), status);
    }
 
    @Override
    public void sessionOpened(IoSession session) throws Exception {
        log.info(df.format(new Date())+"��һ��session��{}#{}", session.getId(), session.getBothIdleCount());
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