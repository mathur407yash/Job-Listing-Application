<%@ page import="com.yash.Joblisting.model.Post" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Find Jobs</title>
</head>
<body>
    <h2>Find a Job</h2>

    <form method="get" action="/findJob">
        <input type="text" name="search" placeholder="Search jobs..." />
        <button type="submit">Search</button>
    </form>

    <hr>
    <h3>Available Jobs:</h3>
    <%
        List<Post> jobs = (List<Post>) request.getAttribute("jobs");
        if (jobs != null && !jobs.isEmpty()) {
            for (Post job : jobs) {
    %>
                <div style="border:1px solid #aaa; padding:10px; margin:10px;">
                    <h4><%= job.getProfile() %></h4>
                    <p><b>Experience:</b> <%= job.getExp() %> years</p>
                    <p><b>Description:</b> <%= job.getDesc() %></p>
                    <p><b>Skills:</b> <%= String.join(", ", job.getTechs()) %></p>
                </div>
    <%
            }
        } else {
    %>
        <p>No jobs found.</p>
    <%
        }
    %>
    <br>
    <a href="/home">Back to Home</a>
</body>
