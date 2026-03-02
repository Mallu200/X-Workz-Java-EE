<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Staff Login | Enterprise Portal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --staff-navy: #0f172a;
            --slate-500: #64748b;
            --error-red: #dc3545;
            --bg-canvas: #f8fafc;
        }

        body {
            background-color: var(--bg-canvas);
            font-family: 'Inter', -apple-system, sans-serif;
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            margin: 0;
            color: var(--staff-navy);
        }

        .login-card {
            max-width: 420px;
            width: 90%;
            background: #ffffff;
            padding: 3rem 2rem;
            border-radius: 16px;
            box-shadow: 0 10px 25px -5px rgba(0, 0, 0, 0.05);
            border: 1px solid #e2e8f0;
            text-align: center;
        }

        .shield-icon {
            color: var(--staff-navy);
            margin-bottom: 1.5rem;
            opacity: 0.9;
        }

        .login-card h3 {
            font-weight: 800;
            letter-spacing: -0.025em;
            margin-bottom: 0.5rem;
        }

        .subtitle {
            font-size: 0.85rem;
            color: var(--slate-500);
            margin-bottom: 2rem;
        }

        .form-control {
            padding: 12px;
            border-radius: 8px;
            border: 1.5px solid #e2e8f0;
            margin-bottom: 1rem;
        }

        .form-control:focus {
            border-color: var(--staff-navy);
            box-shadow: 0 0 0 3px rgba(15, 23, 42, 0.1);
        }

        .btn-login {
            background-color: var(--staff-navy);
            color: #ffffff;
            border: none;
            padding: 12px;
            font-weight: 700;
            border-radius: 8px;
            width: 100%;
            transition: all 0.2s ease;
        }

        .btn-login:hover {
            background-color: #1e293b;
            transform: translateY(-1px);
        }

        .alert-unauthorized {
            background-color: #fff5f5;
            border: 1px solid #feb2b2;
            color: #c53030;
            padding: 10px;
            border-radius: 8px;
            font-size: 0.85rem;
            font-weight: 600;
            margin-top: 1.5rem;
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 8px;
        }
    </style>
</head>
<body>

    <div class="login-card">
        <div class="shield-icon">
            <svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" fill="currentColor" viewBox="0 0 16 16">
                <path d="M5.072.5a.5.5 0 0 1 .43.252L6.003 1.5h3.994l.501-.748a.5.5 0 0 1 .43-.252h2.572a.5.5 0 0 1 .5.5v12a.5.5 0 0 1-.5.5h-2.572a.5.5 0 0 1-.43-.252L9.997 12.5H6.003l-.501.748a.5.5 0 0 1-.43.252H2.5a.5.5 0 0 1-.5-.5v-12a.5.5 0 0 1 .5-.5h2.572z"/>
            </svg>
        </div>

        <h3>Staff Portal</h3>
        <p class="subtitle">Secure Authentication Required</p>

        <form action="do-login" method="POST">
            <input type="text" name="uName" placeholder="Staff Username" class="form-control" required>
            <button type="submit" class="btn-login">Verify Identity</button>
        </form>

        <%-- Unauthorized Error Message --%>
        <% if("unauthorized".equals(request.getParameter("error"))) { %>
            <div class="alert-unauthorized">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" viewBox="0 0 16 16">
                    <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                </svg>
                Access Denied. Please login first.
            </div>
        <% } %>

        <p class="mt-4 text-muted small">
            Bengaluru IT Operations Node
        </p>
    </div>

</body>
</html>