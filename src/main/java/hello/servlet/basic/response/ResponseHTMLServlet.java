package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// client 요청 -> was // HttpServletRequest, HttpServletResponse 객체 생성 -> 서블릿에 전달 -> service // doGet, doPost 요청 전달
// 비즈 로직 처리 -> response 응답
@WebServlet(name = "responseHTMLServlet", urlPatterns = "/response-html")
public class ResponseHTMLServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Content-Type: text/html;charset=utf-8
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        //Servlet -> 불편함 // 자바 로직으로 HTML 그려야함 -> JSP 출시 // 비즈 로직 너무 건드림 -> MVC 나옴
        PrintWriter writer = response.getWriter();
        writer.print("<html>");
        writer.print("<body>");
        writer.print("  <div>안녕하세유!</div>");
        writer.print("  <span>테스트 중이예유!</span>");
        writer.print("</body>");
        writer.print("</html>");
    }
}
