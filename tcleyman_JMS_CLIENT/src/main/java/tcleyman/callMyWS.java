/*******************************************************************************
 * Copyright (c) 2015 Tom Cleymans
 *******************************************************************************/
package tcleyman;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceFeature;

import com.oracle.webservices.api.jms.JMSTransportClientFeature;

//import Jmscode.MyJMSWS;
//import Jmscode.MyJMSWSService;


import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Servlet implementation class callMyWS
 * 
 * http://localhost:7003/tcleyman_JMS_CLIENT-0.0.1-SNAPSHOT/callMyWS
 */
@WebServlet("/callMyWS")
public class callMyWS extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(callMyWS.class
			.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public callMyWS() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);

	}
	
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response)
			{
		try{
		PrintWriter pw = response.getWriter();
		logger.log(Level.INFO, "trying HTTP:");
		pw.println("result of calling HTTP method: " + processHTTPRequest(request, response));
		processHTTPRequest(request, response);
		logger.log(Level.INFO, "trying JMS:");
		pw.println("result of calling JMS method: " + processJMSRequest(request, response));	
		pw.println("in case one of them is failed, please see the console of the WLS.. ");
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
			}

	protected String processHTTPRequest(HttpServletRequest request,
			HttpServletResponse response) { /*
											 * This will call the Http
											 * WebService.. in package Httpcode
											 */
		String result="failed";
		try {
			Httpcode.MyJMSWSService service = new Httpcode.MyJMSWSService();
			
			Object myport = service.getMyJMSWSPort();
			
			if (myport instanceof Httpcode.MyJMSWS1) {
				Httpcode.MyJMSWS1 port = (Httpcode.MyJMSWS1) myport;
				String test = port.sayHello("test1");
				result=test;
				logger.log(Level.INFO, "test1 result: " + test);
				test = port.sayHello2("test2");
				result+=" " + test;
				logger.log(Level.INFO, "test2 result: " + test);
			} 
			else if  (myport instanceof Httpcode.MyJMSWS)
			{
				Httpcode.MyJMSWS port = (Httpcode.MyJMSWS) myport;
				String test = port.sayHello("test1");
				result=test;
				logger.log(Level.INFO, "test1 result: " + test);
				test = port.sayHello2("test2");
				result+=" " + test;
				logger.log(Level.INFO, "test2 result: " + test);
			}
			
			else {
				logger.log(Level.INFO, "sorry port is not of any type");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	protected String processJMSRequest(HttpServletRequest request,
			HttpServletResponse response) { /*
											 * https://docs.oracle.com/middleware
											 * /
											 * 1213/wls/WSGET/jax-ws-jmstransport
											 * .htm#WSGET3619
											 */
		String result="failed";
		try {
			Jmscode.MyJMSWSService service = new Jmscode.MyJMSWSService();
			JMSTransportClientFeature feature = JMSTransportClientFeature
					.builder()
					.jndiInitialContextFactory(
							"weblogic.jndi.WLInitialContextFactory")
					.jndiURL("t3://localhost:7001").build();
			Object myport = service
					.getMyJMSWSPort(new WebServiceFeature[] { feature });
			if (myport instanceof Jmscode.MyJMSWS1) {
				Jmscode.MyJMSWS1 port = (Jmscode.MyJMSWS1) service
						.getMyJMSWSPort(new WebServiceFeature[] { feature });
				String test = port.sayHello("test1");
				result=test;
				logger.log(Level.INFO, "test1 result: " + test);
				test = port.sayHello2("test2");
				result+=" " + test;
				logger.log(Level.INFO, "test2 result: " + test);
			} 
			else if  (myport instanceof Jmscode.MyJMSWS)
			{
				Jmscode.MyJMSWS port = (Jmscode.MyJMSWS) myport;
				String test = port.sayHello("test1");
				result=test;
				logger.log(Level.INFO, "test1 result: " + test);
				test = port.sayHello2("test2");
				result+=" " + test;
				logger.log(Level.INFO, "test2 result: " + test);
			}
			else {
				logger.log(Level.INFO, "sorry port is not of any type");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
