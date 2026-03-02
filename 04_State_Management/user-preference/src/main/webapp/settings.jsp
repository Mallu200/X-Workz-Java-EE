<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Theme Settings | Enterprise Suite</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <%
        // Theme extraction logic
        String bgColor = "#f8fafc"; // Default Light (Slate-50)
        String textColor = "#0f172a"; // Default Navy text
        String activeTheme = "light";

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("siteTheme".equals(c.getName())) {
                    activeTheme = c.getValue();
                    if ("dark".equals(activeTheme)) {
                        bgColor = "#0f172a"; // Deep Navy
                        textColor = "#f8fafc";
                    } else if ("slate".equals(activeTheme)) {
                        bgColor = "#475569"; // Slate Gray
                        textColor = "#ffffff";
                    }
                }
            }
        }
    %>

    <style>
        body {
            background-color: <%= bgColor %>;
            color: <%= textColor %>;
            font-family: 'Inter', sans-serif;
            transition: background-color 0.4s ease, color 0.4s ease;
            min-height: 100vh;
            display: flex;
            align-items: center;
        }

        .settings-card {
            background: #ffffff;
            color: #0f172a; /* Card content remains consistent */
            border-radius: 20px;
            border: none;
            box-shadow: 0 20px 25px -5px rgba(0, 0, 0, 0.2);
        }

        .theme-indicator {
            font-size: 0.75rem;
            font-weight: 700;
            text-transform: uppercase;
            letter-spacing: 0.05em;
            color: #64748b;
        }

        .btn-save {
            background-color: #0f172a;
            color: white;
            font-weight: 700;
            border-radius: 10px;
            padding: 12px;
            border: none;
            transition: transform 0.2s;
        }

        .btn-save:hover {
            opacity: 0.9;
            transform: translateY(-2px);
            color: white;
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-5 col-md-8">
                <div class="card settings-card p-5">
                    <span class="theme-indicator">Workspace Customization</span>
                    <h2 class="fw-bold mt-2 mb-4">Appearance</h2>

                    <p class="text-muted small mb-4">
                        Your theme preference is stored as a browser cookie. This allows the system to remember your choice even after you sign out.
                    </p>

                    <form action="save-theme" method="POST">
                        <label class="form-label fw-bold small text-uppercase">Select Theme</label>
                        <select name="userTheme" class="form-select form-select-lg mb-4 shadow-sm border-2">
                            <option value="light" <%= "light".equals(activeTheme) ? "selected" : "" %>>Default Light</option>
                            <option value="dark" <%= "dark".equals(activeTheme) ? "selected" : "" %>>Professional Deep Navy</option>
                            <option value="slate" <%= "slate".equals(activeTheme) ? "selected" : "" %>>Modern Slate Gray</option>
                        </select>

                        <button type="submit" class="btn-save w-100 mb-3">
                            Apply and Save Changes
                        </button>
                    </form>

                    <div class="text-center">
                        <a href="dashboard.jsp" class="text-decoration-none small fw-bold text-muted">
                            ← Return to Dashboard
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>