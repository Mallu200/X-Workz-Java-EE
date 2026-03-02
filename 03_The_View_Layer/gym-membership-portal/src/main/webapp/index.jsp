<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fitness Center | X-Workz</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --gym-navy: #0f172a;
            --slate-500: #64748b;
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
            color: var(--gym-navy);
        }

        .hero-card {
            max-width: 600px;
            width: 90%;
            background: #ffffff;
            padding: 4rem 2rem;
            border-radius: 24px;
            box-shadow: 0 20px 25px -5px rgba(0, 0, 0, 0.05);
            text-align: center;
            border: 1px solid rgba(255, 255, 255, 0.3);
        }

        .brand-accent {
            display: inline-block;
            background: #f1f5f9;
            color: var(--slate-500);
            padding: 8px 16px;
            border-radius: 100px;
            font-size: 0.75rem;
            font-weight: 800;
            text-transform: uppercase;
            letter-spacing: 0.1em;
            margin-bottom: 1.5rem;
        }

        .hero-card h1 {
            font-weight: 800;
            font-size: 2.5rem;
            letter-spacing: -0.025em;
            margin-bottom: 1rem;
            color: var(--gym-navy);
        }

        .hero-card p {
            color: var(--slate-500);
            font-size: 1.1rem;
            margin-bottom: 2.5rem;
        }

        .btn-access {
            background-color: var(--gym-navy);
            color: #ffffff;
            border: none;
            padding: 16px 40px;
            font-weight: 700;
            font-size: 1.1rem;
            border-radius: 12px;
            transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
            text-decoration: none;
            display: inline-block;
            box-shadow: 0 4px 12px rgba(15, 23, 42, 0.15);
        }

        .btn-access:hover {
            background-color: #1e293b;
            transform: translateY(-2px);
            box-shadow: 0 10px 15px -3px rgba(15, 23, 42, 0.2);
            color: white;
        }

        .feature-list {
            display: flex;
            justify-content: center;
            gap: 20px;
            margin-top: 3rem;
            font-size: 0.8rem;
            font-weight: 700;
            color: #94a3b8;
            text-transform: uppercase;
        }
    </style>
</head>
<body>

    <div class="hero-card">
        <span class="brand-accent">Titan Series Portal</span>
        <h1>X-Workz Fitness</h1>
        <p class="lead">Track your workouts, manage your active membership, and claim your loyalty rewards in one secure dashboard.</p>

        <a href="member-profile" class="btn-access">
            Access My Profile
        </a>

        <div class="feature-list">
            <span>Workout Logs</span>
            <span>•</span>
            <span>Diet Plans</span>
            <span>•</span>
            <span>Rewards</span>
        </div>
    </div>

</body>
</html>