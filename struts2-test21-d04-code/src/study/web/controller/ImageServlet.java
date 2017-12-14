package study.web.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ImageServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int width = 200;
		int height = 35;
		//1.�����ڴ�ͼ��
		BufferedImage image = new BufferedImage(200,35,BufferedImage.TYPE_INT_RGB);
		//2.�õ�����
		Graphics g = image.getGraphics();
		//3.���û��ʵ���ɫ
		g.setColor(Color.BLUE);
		//4.���߿�
		g.drawRect(0, 0, width, height);
		//5.������о
		g.setColor(Color.GRAY);
		//6.������
		g.fillRect(1, 1, width-2, height-2);
		//7.������о
		g.setColor(Color.WHITE);
		//8.��10��������
		//�õ�һ�����������
		Random r = new Random();
		for(int i=0;i<10;i++){
			g.drawLine(r.nextInt(width),r.nextInt(height),r.nextInt(width),r.nextInt(height));
		}
		//9.������о
		Font f = new Font("����",Font.BOLD,25);
		g.setFont(f);
		g.setColor(Color.RED);
		int x = 10;
		//������֤��
		StringBuffer ss = new StringBuffer();
		for(int i=0;i<4;i++){
			String code = String.valueOf(r.nextInt(10));
			g.drawString(code, x+=35, 30);
			ss.append(code);
		}
		//����֤�뱣�浽session����
		request.getSession().setAttribute("scode", ss.toString());
		//10.��ͼƬ������������
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
