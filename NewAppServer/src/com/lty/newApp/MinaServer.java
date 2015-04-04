package com.lty.newApp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.text.DecimalFormat;

import org.apache.log4j.Logger;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
 
/**
 * <b>function:</b> ������������
 * @author hoojo
 * @createDate 2012-6-29 ����07:11:00
 * @file MinaServer.java
 * @package com.hoo.mina.server
 * @project ApacheMiNa
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class MinaServer {

    
    private SocketAcceptor acceptor;
    private int PORT;
    
    public MinaServer() {
        // ������������server�˵�Socket����
        acceptor = new NioSocketAcceptor();
    }
    
    public boolean start() {
    	PORT=5222;
        final Logger log = Logger.getLogger(CharsetDecoder.class);

        DefaultIoFilterChainBuilder filterChain = acceptor.getFilterChain();
        // ��ӱ�������� �������롢��������
        filterChain.addLast("codec", new ProtocolCodecFilter(new CharsetCodecFactory()));
        
        /*LoggingFilter loggingFilter = new LoggingFilter();
        loggingFilter.setMessageReceivedLogLevel(LogLevel.INFO);
        loggingFilter.setMessageSentLogLevel(LogLevel.INFO);
        // �����־������
        filterChain.addLast("loger", loggingFilter);*/
        
        // ���ú�����Ϣҵ������
        acceptor.setHandler(new ServerMessageHandler());
        //session���ö�д ͨ������30 �������κβ����ͽ������״
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 30);
        //���ö�ȡ���ݵĻ�������С
        acceptor.getSessionConfig().setReadBufferSize(2048);
        try {
            // �󶨶˿�
            acceptor.bind(new InetSocketAddress(PORT));
            log.info("�����������ɹ�...    �˿ں�δ��"+PORT);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        MinaServer server = new MinaServer();
        server.start();
    }
}
