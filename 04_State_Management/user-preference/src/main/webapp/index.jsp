<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Global Dashboard | Enterprise Suite</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --prop-navy: #0f172a;
            --slate-600: #475569;
            --bg-app: #f1f5f9;
        }

        body {
            background-color: var(--bg-app);
            font-family: 'Inter', -apple-system, sans-serif;
            color: var(--prop-navy);
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            margin: 0;
        }

        .dashboard-hero {
            max-width: 600px;
            width: 90%;
            background: #ffffff;
            padding: 4rem 2rem;
            border-radius: 24px;
            box-shadow: 0 20px 25px -5px rgba(0, 0, 0, 0.05);
            text-align: center;
        }

        .pref-pill {
            display: inline-flex;
            align-items: center;
            gap: 8px;
            background: #f1f5f9;
            color: var(--slate-600);
            padding: 6px 16px;
            border-radius: 100px;
            font-size: 0.8rem;
            font-weight: 700;
            margin-bottom: 1.5rem;
        }

        .hero-title {
            font-weight: 800;
            font-size: 2.5rem;
            letter-spacing: -0.025em;
            margin-bottom: 1rem;
        }

        .hero-desc {
            color: var(--slate-600);
            font-size: 1.1rem;
            margin-bottom: 2.5rem;
            line-height: 1.6;
        }

        .btn-settings {
            background-color: transparent;
            border: 2px solid var(--prop-navy);
            color: var(--prop-navy);
            padding: 14px 40px;
            font-weight: 700;
            border-radius: 12px;
            text-decoration: none;
            transition: all 0.2s;
            display: inline-block;
        }

        .btn-settings:hover {
            background-color: var(--prop-navy);
            color: #ffffff;
            transform: translateY(-2px);
        }

        .tech-footer {
            margin-top: 3rem;
            padding-top: 1.5rem;
            border-top: 1px solid #f1f5f9;
            font-size: 0.75rem;
            color: #94a3b8;
        }
    </style>
</head>
<body>

    <div class="dashboard-hero">
        <div class="pref-pill">
            <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" fill="currentColor" viewBox="0 0 16 16">
                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
            </svg>
            Client-Side Persistence Active
        </div>

        <h1 class="hero-title">Welcome to your Dashboard</h1>
        <p class="hero-desc">
            Your UI preferences, including the current color scheme and layout density, are handled via browser-level tracking for a faster, more personalized experience.
        </p>

        <a href="settings.jsp" class="btn-settings">
            Customize Environment
        </a>

        <div class="tech-footer">
            <strong>Architecture:</strong> Java EE (Servlets/JSP) + Session Cookies
        </div>
    </div>

</body>
</html>