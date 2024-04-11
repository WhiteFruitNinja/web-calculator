<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Skaičiaus atnaujinimas</title>
        <jsp:include page="header.jsp"/>
    </head>
    <body>
            <form:form name="skaicius" action="/atnaujintiSkaiciu" method="post">
                    <!-- id būtina pateikti formoje, kitaip į back-end nueis null. Todėl darome hidden, kad neredaguotų -->
                    <input type="hidden"    name="id"                       value="${skaicius.id}"><p>
                    Pirmas skaičius:<br>
                    <input type="number"    name="number1"                      value="${skaicius.number1}"><p>
                    Ženklas:<br>
                    <input type="text"      name="operation"                  value="${skaicius.operation}"><p>
                    Antras skaičius:<br>
                    <input type="number"    name="number2"                      value="${skaicius.number2}"><p>
                    Rezultatas:<br>
                    <input type="number"    name="result"                   value="${skaicius.result}"><p>
                    <input type="submit" value="Atnaujinti">
            </form:form>
    </body>
</html>
