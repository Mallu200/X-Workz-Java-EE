<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payroll Entry | CorpConnect ERP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --corp-navy: #0f172a;
            --slate-500: #64748b;
            --border-soft: #e2e8f0;
            --bg-app: #f1f5f9;
        }

        body {
            background-color: var(--bg-app);
            font-family: 'Inter', -apple-system, system-ui, sans-serif;
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            margin: 0;
            padding: 20px;
            color: var(--corp-navy);
        }

        .payroll-card {
            max-width: 420px;
            width: 100%;
            background: #ffffff;
            padding: 2.5rem;
            border-radius: 8px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
            border-top: 5px solid var(--corp-navy);
            /* Ensures content doesn't spill out */
            overflow: visible;
            display: flex;
            flex-direction: column;
        }

        .hr-header {
            margin-bottom: 2rem;
            text-align: center;
        }

        .form-label {
            font-size: 0.8rem;
            font-weight: 700;
            color: var(--slate-500);
            margin-bottom: 0.5rem;
            display: block;
        }

        .form-control {
            border: 1.5px solid var(--border-soft);
            padding: 12px;
            border-radius: 6px;
            margin-bottom: 1.5rem; /* Increased spacing */
        }

        /* VIZUALIZATION FIX: Explicit button sizing and color */
        .btn-check {
            background-color: var(--corp-navy) !important;
            color: #ffffff !important;
            border: none;
            padding: 14px;
            font-weight: 700;
            width: 100%;
            border-radius: 6px;
            display: block;
            cursor: pointer;
            position: relative;
            z-index: 10;
            transition: transform 0.2s, background 0.2s;
        }

        .btn-check:hover {
            background-color: #1e293b !important;
            transform: translateY(-2px);
        }

        .security-badge {
            text-align: center;
            margin-top: 2rem;
            font-size: 0.7rem;
            color: #94a3b8;
        }
    </style>
</head>
<body>

    <div class="payroll-card">
        <div class="hr-header">
            <h3 class="fw-bold">Payroll Entry</h3>
            <p class="text-uppercase small fw-bold text-muted">HR Portal</p>
        </div>

        <form action="check-payroll" method="POST">
            <label class="form-label">Employee Full Name</label>
            <input type="text" name="empName" placeholder="e.g. C Mallikarjun" class="form-control" required>

            <label class="form-label">Monthly Gross Salary (₹)</label>
            <input type="number" name="salary" placeholder="Enter amount" class="form-control" required>

            <button type="submit" class="btn-check">
                Check Payroll Status
            </button>
        </form>

        <div class="security-badge">
            🔒 Internal HR Access Only | CorpConnect
        </div>
    </div>

</body>
</html>