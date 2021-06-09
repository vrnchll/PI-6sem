import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.jackrabbit.webdav.client.methods.CopyMethod;
import org.apache.jackrabbit.webdav.client.methods.DavMethod;
import org.apache.jackrabbit.webdav.client.methods.MkColMethod;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class Sss extends HttpServlet implements Servlet {

	protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		String op_type = rq.getParameter("Add");
		if(rq.getParameter("add").equals("Create Directory"))
		{
			String response = null;
			HttpClient client = new HttpClient( );
			String url = "https://webdav.yandex.ru";
			client.getState().setCredentials(
					new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
					new UsernamePasswordCredentials("veronichka127@mail.ru", "zwovwamdbwtucxiy"));
			DavMethod method = new MkColMethod(url);
			try
			{
				client.executeMethod(new MkColMethod(url + "/" + rq.getParameter("dir")));
			}
			catch (IOException ex)
			{
			}
			finally
			{
				method.releaseConnection();
			}
			PrintWriter writer = rs.getWriter();
			writer.println("Directory was successfully created");
			writer.close();
		}
		if(rq.getParameter("add").equals("Download"))
		{
			String response = null;
			HttpClient client = new HttpClient( );
			String url = "https://webdav.yandex.ru";
			client.getState().setCredentials(
					new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
					new UsernamePasswordCredentials("veronichka127@mail.ru", "zwovwamdbwtucxiy"));
			DavMethod method = new MkColMethod(url);
			try
			{
				String docdir   = getServletContext().getInitParameter("doc-dir");
				GetMethod httpMethod = new GetMethod(url + "/" + rq.getParameter("dir"));
				client.executeMethod(httpMethod);
				InputStream inputStream = httpMethod.getResponseBodyAsStream();
				File fff = new File(docdir + rq.getParameter("dir"));
				OutputStream outputStream = new FileOutputStream(fff);
				byte[] buf = new byte[1024];
				int len;
				while ((len = inputStream.read(buf)) > 0){
					outputStream.write(buf, 0, len);
				}
				outputStream.close();
				inputStream.close();

			}
			catch (IOException ex)
			{
			}
			finally
			{
				method.releaseConnection();
			}
			PrintWriter writer = rs.getWriter();
			writer.println("Successfully downloaded");
			writer.close();
		}
		if(rq.getParameter("add").equals("Upload"))
		{
			String response = null;
			HttpClient client = new HttpClient( );
			String url = "https://webdav.yandex.ru";
			client.getState().setCredentials(
					new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
					new UsernamePasswordCredentials("veronichka127@mail.ru", "zwovwamdbwtucxiy"));

			String docdir   = getServletContext().getInitParameter("doc-dir");
			String path = rq.getParameter("dir");
			File from = new File("A:\\Files\\"+path);
			PutMethod method = new PutMethod(url + "/" + from.getName());
			RequestEntity requestEntity = new InputStreamRequestEntity(
					new FileInputStream(from));
			method.setRequestEntity(requestEntity);
			client.executeMethod(method);

			PrintWriter writer = rs.getWriter();
			writer.println("Successfully uploaded");
			writer.close();
		}
		if(rq.getParameter("add").equals("Delete"))
		{
			HttpClient client = new HttpClient( );
			String url = "https://webdav.yandex.ru";
			client.getState().setCredentials(
					new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
					new UsernamePasswordCredentials("veronichka127@mail.ru", "zwovwamdbwtucxiy"));
			org.apache.commons.httpclient.methods.DeleteMethod method =
					new org.apache.commons.httpclient.methods.DeleteMethod(
							url + "/" + rq.getParameter("dir"));
			try
			{
				client.executeMethod(method);
			}
			catch (IOException ex)
			{
			}
			finally
			{
				method.releaseConnection();
			}
			PrintWriter writer = rs.getWriter();
			writer.println("Successfully deleted");
			writer.close();
		}
		if(rq.getParameter("add").equals("Copy"))
		{
			HttpClient client = new HttpClient( );
			String url = "https://webdav.yandex.ru";
			client.getState().setCredentials(
					new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
					new UsernamePasswordCredentials("veronichka127@mail.ru", "zwovwamdbwtucxiy"));
			CopyMethod method =
					new CopyMethod(
							url + "/" + rq.getParameter("dir"),url + "/" + rq.getParameter("todir") + "/" +  rq.getParameter("dir"),true);
			try
			{
				client.executeMethod(method);
			}
			catch (IOException ex)
			{
			}
			finally
			{
				method.releaseConnection();
			}
			PrintWriter writer = rs.getWriter();
			writer.println("Successfully copied");
			writer.close();
		}
	}
}