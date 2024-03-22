<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Calculator</title>
</head>
<body>
    <h2>Web Calculator. Operations: Add | Subtract | Multiply | Divide</h2>
    <form method="post" action="calculate">
        First number: <input type = "number" name="number1"><p>
        Second number: <input type = "number" name="number2"><p>
        Operation symbol:
        <select name="symbol">
                <option selected="selected" value="+">Add</option>
                <option value="-">Subtract</option>
                <option value="*">Multiply</option>
                <option value="/">Divide</option>
        </select><p>
        <input type="submit" value="Calculate">
    </form>

    <% if (request.getAttribute("error") != null) { %>
        <div class="error">
            Error: ${error}
        </div>
    <% } %>
</body>
</html>
