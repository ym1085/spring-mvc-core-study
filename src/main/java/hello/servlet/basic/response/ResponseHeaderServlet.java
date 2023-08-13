package hello.servlet.basic.response;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setStatus(200); // 200 OK

        // [status-line]
        response.setStatus(HttpServletResponse.SC_OK); // 200 OK
        // response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        // response header
        response.setHeader("Content-Type", "text/plain;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header",  "hello");

        // header 편의 메서드
        //content(response);
        //cookie(response);
        redirect(response);

        // [message body]
        PrintWriter writer = response.getWriter();
        writer.println("ok");
    }

    /**
     * content-type 지정
     * @param response
     */
    private void content(HttpServletResponse response) {
        //Content-Type: text/plain; charset=utf-8
        //Content-Length: 2
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain"); // 응답 데이터 타입 지정
        response.setCharacterEncoding("UTF-8"); // 응답 데이터 인코딩 지정
    }

    /**
     * cookie 셋팅
     * @param response
     */
    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age=600;
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good"); //쿠키 생성
        cookie.setMaxAge(600); //유효기간 600초 셋팅
        response.addCookie(cookie); //쿠키 추가
    }

    /**
     * redirect 302 수행
     * @param response
     * @throws IOException
     */
    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html

        /*response.setStatus(HttpServletResponse.SC_FOUND); // 302
        response.setHeader("Location", "/basic/hello-form.html");*/
        response.sendRedirect("/basic/hello-form.html"); // 위랑 동일함
    }
}
