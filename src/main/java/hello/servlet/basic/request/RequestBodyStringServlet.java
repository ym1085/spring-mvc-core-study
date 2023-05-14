package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream(); // parsing message body, 메시지 바디의 내용을 바이트코드(Byte Code)로 얻을 수 있다
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);// Spring이 제공하는 유틸리티 StreamUtils 클래스 사용, 바이트 -> String 변환

        System.out.println("messageBody = " + messageBody);
        response.getWriter().write("POST - parsing body is ok");
    }
}
