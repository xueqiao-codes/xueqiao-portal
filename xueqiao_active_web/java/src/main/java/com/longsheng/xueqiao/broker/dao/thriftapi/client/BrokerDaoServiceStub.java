package com.longsheng.xueqiao.broker.dao.thriftapi.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.client.ServiceException;
import org.soldier.platform.svr_platform.client.ServiceFinderFactory;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import org.soldier.platform.svr_platform.comm.SvrConfiguration;
import org.soldier.platform.svr_platform.thrift.InpSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.soldier.platform.svr_platform.client.BaseStub;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerAccessEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.RemoveBrokerAccessEntryResp;
import com.longsheng.xueqiao.broker.dao.thriftapi.RemoveBrokerEntryResp;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerAccessEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.WorkingBrokerAccessEntryResp;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerDaoService;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerDaoServiceVariable;

public class BrokerDaoServiceStub extends BaseStub {

  public BrokerDaoServiceStub() {
    super(BrokerDaoServiceVariable.serviceKey);
}

  public int  addBrokerEntry(int routeKey, int timeout,com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    TTransport socketTransport = null;
    String ip = null ;
    int port = 0;
    if (SvrConfiguration.getIsUsingInpService() && SvrConfiguration.isServiceInProcess(BrokerDaoServiceVariable.serviceKey)) { 
      socketTransport = new InpSocket(BrokerDaoServiceVariable.serviceKey, timeout);
    } else {
      try{
        ip = chooseServiceAddr("addBrokerEntry", routeKey);
      } catch (ServiceException e1) { throw new TException(e1.getMessage());} 
        port =  chooseServicePort("addBrokerEntry");
        socketTransport = new TSocket(ip, port, timeout);
    }
    TTransport transport = new TFramedTransport(socketTransport);
    TProtocol protocol = new TCompactProtocol(transport);
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);

    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
         callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
         + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    if(ip != null) { platformArgs.setRemoteAddress(ip); }
    if(port != 0) { platformArgs.setRemotePort(port); }
    BrokerDaoService.Client client = new  BrokerDaoService.Client(protocol);
    int result = 0;
    try {
      transport.open();
      result = client.addBrokerEntry(platformArgs, brokerEntry);
      ServiceFinderFactory.getServiceFinder().updateCallInfo(
        BrokerDaoServiceVariable.serviceKey,"addBrokerEntry", ip, null);
    } catch (TException e) {
      ServiceFinderFactory.getServiceFinder().updateCallInfo(
        BrokerDaoServiceVariable.serviceKey,"addBrokerEntry", ip, e);
      throw e;
    }finally{
      transport.close();
    }
    return result;
  }

  public void  updateBrokerEntry(int routeKey, int timeout,com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    TTransport socketTransport = null;
    String ip = null ;
    int port = 0;
    if (SvrConfiguration.getIsUsingInpService() && SvrConfiguration.isServiceInProcess(BrokerDaoServiceVariable.serviceKey)) { 
      socketTransport = new InpSocket(BrokerDaoServiceVariable.serviceKey, timeout);
    } else {
      try{
        ip = chooseServiceAddr("updateBrokerEntry", routeKey);
      } catch (ServiceException e1) { throw new TException(e1.getMessage());} 
        port =  chooseServicePort("updateBrokerEntry");
        socketTransport = new TSocket(ip, port, timeout);
    }
    TTransport transport = new TFramedTransport(socketTransport);
    TProtocol protocol = new TCompactProtocol(transport);
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);

    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
         callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
         + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    if(ip != null) { platformArgs.setRemoteAddress(ip); }
    if(port != 0) { platformArgs.setRemotePort(port); }
    BrokerDaoService.Client client = new  BrokerDaoService.Client(protocol);
    try {
      transport.open();
      client.updateBrokerEntry(platformArgs, brokerEntry);
      ServiceFinderFactory.getServiceFinder().updateCallInfo(
        BrokerDaoServiceVariable.serviceKey,"updateBrokerEntry", ip, null);
    } catch (TException e) {
      ServiceFinderFactory.getServiceFinder().updateCallInfo(
        BrokerDaoServiceVariable.serviceKey,"updateBrokerEntry", ip, e);
      throw e;
    }finally{
      transport.close();
    }
  }

  public BrokerEntryPage  reqBrokerEntry(int routeKey, int timeout,ReqBrokerEntryOption option, int pageIndex, int pageSize)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    TTransport socketTransport = null;
    String ip = null ;
    int port = 0;
    if (SvrConfiguration.getIsUsingInpService() && SvrConfiguration.isServiceInProcess(BrokerDaoServiceVariable.serviceKey)) { 
      socketTransport = new InpSocket(BrokerDaoServiceVariable.serviceKey, timeout);
    } else {
      try{
        ip = chooseServiceAddr("reqBrokerEntry", routeKey);
      } catch (ServiceException e1) { throw new TException(e1.getMessage());} 
        port =  chooseServicePort("reqBrokerEntry");
        socketTransport = new TSocket(ip, port, timeout);
    }
    TTransport transport = new TFramedTransport(socketTransport);
    TProtocol protocol = new TCompactProtocol(transport);
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);

    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
         callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
         + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    if(ip != null) { platformArgs.setRemoteAddress(ip); }
    if(port != 0) { platformArgs.setRemotePort(port); }
    BrokerDaoService.Client client = new  BrokerDaoService.Client(protocol);
    BrokerEntryPage result = null;
    try {
      transport.open();
      result = client.reqBrokerEntry(platformArgs, option, pageIndex, pageSize);
      ServiceFinderFactory.getServiceFinder().updateCallInfo(
        BrokerDaoServiceVariable.serviceKey,"reqBrokerEntry", ip, null);
    } catch (TException e) {
      ServiceFinderFactory.getServiceFinder().updateCallInfo(
        BrokerDaoServiceVariable.serviceKey,"reqBrokerEntry", ip, e);
      throw e;
    }finally{
      transport.close();
    }
    return result;
  }

  public int  addBrokerAccessEntry(int routeKey, int timeout,com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    TTransport socketTransport = null;
    String ip = null ;
    int port = 0;
    if (SvrConfiguration.getIsUsingInpService() && SvrConfiguration.isServiceInProcess(BrokerDaoServiceVariable.serviceKey)) { 
      socketTransport = new InpSocket(BrokerDaoServiceVariable.serviceKey, timeout);
    } else {
      try{
        ip = chooseServiceAddr("addBrokerAccessEntry", routeKey);
      } catch (ServiceException e1) { throw new TException(e1.getMessage());} 
        port =  chooseServicePort("addBrokerAccessEntry");
        socketTransport = new TSocket(ip, port, timeout);
    }
    TTransport transport = new TFramedTransport(socketTransport);
    TProtocol protocol = new TCompactProtocol(transport);
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);

    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
         callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
         + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    if(ip != null) { platformArgs.setRemoteAddress(ip); }
    if(port != 0) { platformArgs.setRemotePort(port); }
    BrokerDaoService.Client client = new  BrokerDaoService.Client(protocol);
    int result = 0;
    try {
      transport.open();
      result = client.addBrokerAccessEntry(platformArgs, brokerAccessEntry);
      ServiceFinderFactory.getServiceFinder().updateCallInfo(
        BrokerDaoServiceVariable.serviceKey,"addBrokerAccessEntry", ip, null);
    } catch (TException e) {
      ServiceFinderFactory.getServiceFinder().updateCallInfo(
        BrokerDaoServiceVariable.serviceKey,"addBrokerAccessEntry", ip, e);
      throw e;
    }finally{
      transport.close();
    }
    return result;
  }

  public void  updateBrokerAccessEntry(int routeKey, int timeout,com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    TTransport socketTransport = null;
    String ip = null ;
    int port = 0;
    if (SvrConfiguration.getIsUsingInpService() && SvrConfiguration.isServiceInProcess(BrokerDaoServiceVariable.serviceKey)) { 
      socketTransport = new InpSocket(BrokerDaoServiceVariable.serviceKey, timeout);
    } else {
      try{
        ip = chooseServiceAddr("updateBrokerAccessEntry", routeKey);
      } catch (ServiceException e1) { throw new TException(e1.getMessage());} 
        port =  chooseServicePort("updateBrokerAccessEntry");
        socketTransport = new TSocket(ip, port, timeout);
    }
    TTransport transport = new TFramedTransport(socketTransport);
    TProtocol protocol = new TCompactProtocol(transport);
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);

    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
         callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
         + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    if(ip != null) { platformArgs.setRemoteAddress(ip); }
    if(port != 0) { platformArgs.setRemotePort(port); }
    BrokerDaoService.Client client = new  BrokerDaoService.Client(protocol);
    try {
      transport.open();
      client.updateBrokerAccessEntry(platformArgs, brokerAccessEntry);
      ServiceFinderFactory.getServiceFinder().updateCallInfo(
        BrokerDaoServiceVariable.serviceKey,"updateBrokerAccessEntry", ip, null);
    } catch (TException e) {
      ServiceFinderFactory.getServiceFinder().updateCallInfo(
        BrokerDaoServiceVariable.serviceKey,"updateBrokerAccessEntry", ip, e);
      throw e;
    }finally{
      transport.close();
    }
  }

  public BrokerAccessEntryPage  reqBrokerAccessEntry(int routeKey, int timeout,ReqBrokerAccessEntryOption option, int pageIndex, int pageSize)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    TTransport socketTransport = null;
    String ip = null ;
    int port = 0;
    if (SvrConfiguration.getIsUsingInpService() && SvrConfiguration.isServiceInProcess(BrokerDaoServiceVariable.serviceKey)) { 
      socketTransport = new InpSocket(BrokerDaoServiceVariable.serviceKey, timeout);
    } else {
      try{
        ip = chooseServiceAddr("reqBrokerAccessEntry", routeKey);
      } catch (ServiceException e1) { throw new TException(e1.getMessage());} 
        port =  chooseServicePort("reqBrokerAccessEntry");
        socketTransport = new TSocket(ip, port, timeout);
    }
    TTransport transport = new TFramedTransport(socketTransport);
    TProtocol protocol = new TCompactProtocol(transport);
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);

    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
         callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
         + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    if(ip != null) { platformArgs.setRemoteAddress(ip); }
    if(port != 0) { platformArgs.setRemotePort(port); }
    BrokerDaoService.Client client = new  BrokerDaoService.Client(protocol);
    BrokerAccessEntryPage result = null;
    try {
      transport.open();
      result = client.reqBrokerAccessEntry(platformArgs, option, pageIndex, pageSize);
      ServiceFinderFactory.getServiceFinder().updateCallInfo(
        BrokerDaoServiceVariable.serviceKey,"reqBrokerAccessEntry", ip, null);
    } catch (TException e) {
      ServiceFinderFactory.getServiceFinder().updateCallInfo(
        BrokerDaoServiceVariable.serviceKey,"reqBrokerAccessEntry", ip, e);
      throw e;
    }finally{
      transport.close();
    }
    return result;
  }

  public WorkingBrokerAccessEntryResp  reqWorkingBrokerAccessEntry(int routeKey, int timeout,int brokerAccessEntryId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    TTransport socketTransport = null;
    String ip = null ;
    int port = 0;
    if (SvrConfiguration.getIsUsingInpService() && SvrConfiguration.isServiceInProcess(BrokerDaoServiceVariable.serviceKey)) { 
      socketTransport = new InpSocket(BrokerDaoServiceVariable.serviceKey, timeout);
    } else {
      try{
        ip = chooseServiceAddr("reqWorkingBrokerAccessEntry", routeKey);
      } catch (ServiceException e1) { throw new TException(e1.getMessage());} 
        port =  chooseServicePort("reqWorkingBrokerAccessEntry");
        socketTransport = new TSocket(ip, port, timeout);
    }
    TTransport transport = new TFramedTransport(socketTransport);
    TProtocol protocol = new TCompactProtocol(transport);
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);

    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
         callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
         + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    if(ip != null) { platformArgs.setRemoteAddress(ip); }
    if(port != 0) { platformArgs.setRemotePort(port); }
    BrokerDaoService.Client client = new  BrokerDaoService.Client(protocol);
    WorkingBrokerAccessEntryResp result = null;
    try {
      transport.open();
      result = client.reqWorkingBrokerAccessEntry(platformArgs, brokerAccessEntryId);
      ServiceFinderFactory.getServiceFinder().updateCallInfo(
        BrokerDaoServiceVariable.serviceKey,"reqWorkingBrokerAccessEntry", ip, null);
    } catch (TException e) {
      ServiceFinderFactory.getServiceFinder().updateCallInfo(
        BrokerDaoServiceVariable.serviceKey,"reqWorkingBrokerAccessEntry", ip, e);
      throw e;
    }finally{
      transport.close();
    }
    return result;
  }

  public WorkingBrokerAccessEntryResp  syncBrokerAccessEntry(int routeKey, int timeout,int brokerAccessEntryId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    TTransport socketTransport = null;
    String ip = null ;
    int port = 0;
    if (SvrConfiguration.getIsUsingInpService() && SvrConfiguration.isServiceInProcess(BrokerDaoServiceVariable.serviceKey)) { 
      socketTransport = new InpSocket(BrokerDaoServiceVariable.serviceKey, timeout);
    } else {
      try{
        ip = chooseServiceAddr("syncBrokerAccessEntry", routeKey);
      } catch (ServiceException e1) { throw new TException(e1.getMessage());} 
        port =  chooseServicePort("syncBrokerAccessEntry");
        socketTransport = new TSocket(ip, port, timeout);
    }
    TTransport transport = new TFramedTransport(socketTransport);
    TProtocol protocol = new TCompactProtocol(transport);
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);

    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
         callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
         + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    if(ip != null) { platformArgs.setRemoteAddress(ip); }
    if(port != 0) { platformArgs.setRemotePort(port); }
    BrokerDaoService.Client client = new  BrokerDaoService.Client(protocol);
    WorkingBrokerAccessEntryResp result = null;
    try {
      transport.open();
      result = client.syncBrokerAccessEntry(platformArgs, brokerAccessEntryId);
      ServiceFinderFactory.getServiceFinder().updateCallInfo(
        BrokerDaoServiceVariable.serviceKey,"syncBrokerAccessEntry", ip, null);
    } catch (TException e) {
      ServiceFinderFactory.getServiceFinder().updateCallInfo(
        BrokerDaoServiceVariable.serviceKey,"syncBrokerAccessEntry", ip, e);
      throw e;
    }finally{
      transport.close();
    }
    return result;
  }

  public RemoveBrokerAccessEntryResp  removeBrokerAccessEntry(int routeKey, int timeout,int brokerAccessEntryId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    TTransport socketTransport = null;
    String ip = null ;
    int port = 0;
    if (SvrConfiguration.getIsUsingInpService() && SvrConfiguration.isServiceInProcess(BrokerDaoServiceVariable.serviceKey)) { 
      socketTransport = new InpSocket(BrokerDaoServiceVariable.serviceKey, timeout);
    } else {
      try{
        ip = chooseServiceAddr("removeBrokerAccessEntry", routeKey);
      } catch (ServiceException e1) { throw new TException(e1.getMessage());} 
        port =  chooseServicePort("removeBrokerAccessEntry");
        socketTransport = new TSocket(ip, port, timeout);
    }
    TTransport transport = new TFramedTransport(socketTransport);
    TProtocol protocol = new TCompactProtocol(transport);
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);

    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
         callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
         + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    if(ip != null) { platformArgs.setRemoteAddress(ip); }
    if(port != 0) { platformArgs.setRemotePort(port); }
    BrokerDaoService.Client client = new  BrokerDaoService.Client(protocol);
    RemoveBrokerAccessEntryResp result = null;
    try {
      transport.open();
      result = client.removeBrokerAccessEntry(platformArgs, brokerAccessEntryId);
      ServiceFinderFactory.getServiceFinder().updateCallInfo(
        BrokerDaoServiceVariable.serviceKey,"removeBrokerAccessEntry", ip, null);
    } catch (TException e) {
      ServiceFinderFactory.getServiceFinder().updateCallInfo(
        BrokerDaoServiceVariable.serviceKey,"removeBrokerAccessEntry", ip, e);
      throw e;
    }finally{
      transport.close();
    }
    return result;
  }

  public RemoveBrokerEntryResp  removeBrokerEntry(int routeKey, int timeout,int brokerEntryId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    TTransport socketTransport = null;
    String ip = null ;
    int port = 0;
    if (SvrConfiguration.getIsUsingInpService() && SvrConfiguration.isServiceInProcess(BrokerDaoServiceVariable.serviceKey)) { 
      socketTransport = new InpSocket(BrokerDaoServiceVariable.serviceKey, timeout);
    } else {
      try{
        ip = chooseServiceAddr("removeBrokerEntry", routeKey);
      } catch (ServiceException e1) { throw new TException(e1.getMessage());} 
        port =  chooseServicePort("removeBrokerEntry");
        socketTransport = new TSocket(ip, port, timeout);
    }
    TTransport transport = new TFramedTransport(socketTransport);
    TProtocol protocol = new TCompactProtocol(transport);
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);

    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
         callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
         + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    if(ip != null) { platformArgs.setRemoteAddress(ip); }
    if(port != 0) { platformArgs.setRemotePort(port); }
    BrokerDaoService.Client client = new  BrokerDaoService.Client(protocol);
    RemoveBrokerEntryResp result = null;
    try {
      transport.open();
      result = client.removeBrokerEntry(platformArgs, brokerEntryId);
      ServiceFinderFactory.getServiceFinder().updateCallInfo(
        BrokerDaoServiceVariable.serviceKey,"removeBrokerEntry", ip, null);
    } catch (TException e) {
      ServiceFinderFactory.getServiceFinder().updateCallInfo(
        BrokerDaoServiceVariable.serviceKey,"removeBrokerEntry", ip, e);
      throw e;
    }finally{
      transport.close();
    }
    return result;
  }

}
