<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Summary | CoreBank ERP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --bank-navy: #0f172a;
            --slate-600: #475569;
            --bg-canvas: #f1f5f9;
            --accent-green: #10b981;
        }

        body {
            background-color: var(--bg-canvas);
            font-family: 'Inter', -apple-system, sans-serif;
            margin: 0;
            color: var(--bank-navy);
        }

        /* Modern Navbar */
        .bank-nav {
            background-color: var(--bank-navy);
            padding: 1rem 0;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }

        .navbar-brand {
            font-weight: 800;
            letter-spacing: -0.5px;
        }

        .summary-card {
            max-width: 600px;
            background: #ffffff;
            border-radius: 16px;
            border: 1px solid #e2e8f0;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.05);
            overflow: hidden;
            margin-top: 50px;
        }

        .card-accent {
            height: 6px;
            background: linear-gradient(90deg, var(--bank-navy), #1e293b);
        }

        .card-body-main {
            padding: 2.5rem;
        }

        .label-text {
            font-size: 0.75rem;
            font-weight: 700;
            text-transform: uppercase;
            letter-spacing: 0.05em;
            color: var(--slate-600);
            display: block;
            margin-bottom: 0.5rem;
        }

        .account-holder {
            font-size: 1.5rem;
            font-weight: 800;
            margin-bottom: 1.5rem;
        }

        .balance-box {
            background-color: #f8fafc;
            padding: 1.5rem;
            border-radius: 12px;
            border: 1px solid #f1f5f9;
            margin-bottom: 2rem;
        }

        .balance-amount {
            font-size: 2.25rem;
            font-weight: 800;
            color: var(--bank-navy);
        }

        .status-pill {
            display: inline-flex;
            align-items: center;
            gap: 6px;
            font-size: 0.8rem;
            font-weight: 700;
            color: var(--accent-green);
            background: #ecfdf5;
            padding: 4px 12px;
            border-radius: 100px;
            margin-bottom: 1rem;
        }

        .btn-logout {
            background-color: transparent;
            border: 2px solid #ef4444;
            color: #ef4444;
            font-weight: 700;
            padding: 12px;
            width: 100%;
            border-radius: 8px;
            text-decoration: none;
            display: block;
            text-align: center;
            transition: all 0.2s;
        }

        .btn-logout:hover {
            background-color: #ef4444;
            color: #ffffff;
        }
    </style>
</head>
<body>

    <nav class="bank-nav">
        <div class="container d-flex justify-content-between align-items-center">
            <span class="navbar-brand text-white">COREBANK ERP</span>
            <span class="text-white opacity-75 small">Session Active</span>
        </div>
    </nav>

    <div class="container d-flex justify-content-center">
        <div class="summary-card">
            <div class="card-accent"></div>
            <div class="card-body-main">

                <div class="status-pill">
                    <span style="width: 8px; height: 8px; background: var(--accent-green); border-radius: 50%;"></span>
                    Verified Secure Access
                </div>

                <span class="label-text">Account Holder</span>
                <h2 class="account-holder">${sessionScope.userSession.accountHolder}</h2>

                <div class="balance-box">
                    <span class="label-text">Available Balance</span>
                    <div class="balance-amount">₹${sessionScope.userSession.balance}</div>
                    <p class="text-muted small mb-0 mt-2">Account No: ${sessionScope.userSession.accountNumber}</p>
                </div>

                <hr class="my-4" style="opacity: 0.1;">

                <div class="row g-2">
                    <div class="col-6">
                        <a href="transactions" class="btn btn-dark w-100 fw-bold py-2" style="background: var(--bank-navy);">Transactions</a>
                    </div>
                    <div class="col-6">
                        <a href="logout" class="btn-logout">Secure Logout</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>