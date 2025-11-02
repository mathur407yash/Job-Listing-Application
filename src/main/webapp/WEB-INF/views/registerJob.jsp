<!DOCTYPE html>
<html>
<head>
    <title>Register Job</title>
</head>
<body>
    <h2>Register a New Job</h2>
    <form action="/registerJob" method="post">
        <label>Job Title:</label>
        <input type="text" name="profile" required><br><br>

        <label>Experience (years):</label>
        <input type="number" name="exp" required><br><br>

        <label>Description:</label><br>
        <textarea name="desc" rows="4" cols="40" required></textarea><br><br>

        <label>Skills (comma separated):</label>
        <input type="text" name="techs" placeholder="Java, Spring, MongoDB" required><br><br>

        <button type="submit">Submit</button>
    </form>

    <br><a href="/home">Back to Home</a>
</body>
</html>
