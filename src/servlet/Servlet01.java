package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletContext全局参数的设置及应用
 * 使用ServletContext全局参数来获取点击访问Servlet01的次数
 * Servlet implementation class Servlet01
 */
public class Servlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取ServletContext容器对象
		ServletContext sc = getServletContext();
		//通过容器对象获取全局的属性值
		//pvcount 访问Servlet01的次数
		Integer pvcount = (Integer) sc.getAttribute("pvcount");
		if(pvcount == null){
			sc.setAttribute("pvcount", 1);
		}else{
			sc.setAttribute("pvcount", ++pvcount);
		}
		pvcount = (Integer) sc.getAttribute("pvcount");
		String result = "<font color='red' size='20'>--当前站点被点击了"+pvcount+"次</font>";
		response.getOutputStream().write(result.getBytes());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
