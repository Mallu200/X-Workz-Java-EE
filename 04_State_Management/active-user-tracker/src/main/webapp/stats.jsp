<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Platform Analytics | Enterprise Suite</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --stats-navy: #0f172a;
            --slate-500: #64748b;
            --active-emerald: #10b981;
            --bg-app: #f1f5f9;
        }

        body {
            background-color: var(--bg-app);
            font-family: 'Inter', -apple-system, sans-serif;
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            margin: 0;
        }

        .stats-card {
            max-width: 450px;
            width: 90%;
            background: #ffffff;
            border-radius: 24px;
            border: 1px solid #e2e8f0;
            box-shadow: 0 20px 25px -5px rgba(0, 0, 0, 0.05);
            padding: 3rem 2rem;
            text-align: center;
        }

        .activity-label {
            font-size: 0.8rem;
            font-weight: 700;
            text-transform: uppercase;
            letter-spacing: 0.1em;
            color: var(--slate-500);
            margin-bottom: 1.5rem;
            display: block;
        }

        .user-count {
            font-size: 6rem;
            font-weight: 800;
            color: var(--stats-navy);
            line-height: 1;
            letter-spacing: -0.05em;
            margin-bottom: 1rem;
        }

        .pulse-badge {
            display: inline-flex;
            align-items: center;
            gap: 8px;
            background-color: #ecfdf5;
            color: #065f46;
            padding: 8px 20px;
            border-radius: 100px;
            font-weight: 700;
            font-size: 0.9rem;
        }

        .pulse-dot {
            width: 10px;
            height: 10px;
            background-color: var(--active-emerald);
            border-radius: 50%;
            box-shadow: 0 0 0 rgba(16, 185, 129, 0.4);
            animation: pulse 2s infinite;
        }

        @keyframes pulse {
            0% { box-shadow: 0 0 0 0 rgba(16, 185, 129, 0.7); }
            70% { box-shadow: 0 0 0 10px rgba(16, 185, 129, 0); }
            100% { box-shadow: 0 0 0 0 rgba(16, 185, 129, 0); }
        }

        .btn-refresh {
            margin-top: 2.5rem;
            background-color: transparent;
            border: 2px solid var(--stats-navy);
            color: var(--stats-navy);
            font-weight: 700;
            padding: 12px 30px;
            border-radius: 12px;
            transition: all 0.2s;
            text-decoration: none;
            display: inline-block;
        }

        .btn-refresh:hover {
            background-color: var(--stats-navy);
            color: #ffffff;
            transform: scale(1.05);
        }
    </style>
</head>
<body>

    <div class="stats-card">
        <span class="activity-label">Live Analytics</span>

        <h1 class="user-count">${onlineNow}</h1>

        <div class="pulse-badge">
            <div class="pulse-dot"></div>
            Concurrent Active Sessions
        </div>

        <p class="text-muted mt-4 small">
            Real-time tracking enabled across all Bengaluru-based application clusters.
        </p>

        <a href="view-stats" class="btn-refresh">
            Update Dashboard
        </a>
    </div>

</body>
</html>