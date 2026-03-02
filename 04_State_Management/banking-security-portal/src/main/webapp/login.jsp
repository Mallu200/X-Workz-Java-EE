<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Secure Login | CoreBank ERP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --bank-navy: #0f172a;
            --slate-500: #64748b;
            --border-soft: #e2e8f0;
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
            color: var(--bank-navy);
        }

        .login-card {
            max-width: 400px;
            width: 95%;
            background: #ffffff;
            padding: 3rem 2.5rem;
            border-radius: 12px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.05);
            border-top: 6px solid var(--bank-navy);
        }

        .bank-header {
            text-align: center;
            margin-bottom: 2.5rem;
        }

        .bank-header h3 {
            font-weight: 800;
            letter-spacing: -0.5px;
            margin-bottom: 0.25rem;
        }

        .bank-header p {
            font-size: 0.8rem;
            color: var(--slate-500);
            text-transform: uppercase;
            font-weight: 700;
            letter-spacing: 0.05em;
        }

        .form-label {
            font-size: 0.75rem;
            font-weight: 800;
            color: var(--slate-500);
            text-transform: uppercase;
            margin-bottom: 0.5rem;
            display: block;
        }

        .form-control {
            border: 1.5px solid var(--border-soft);
            padding: 12px;
            border-radius: 8px;
            font-size: 0.95rem;
            background-color: #fcfdfe;
        }

        .form-control:focus {
            border-color: var(--bank-navy);
            box-shadow: 0 0 0 4px rgba(15, 23, 42, 0.08);
            outline: none;
        }

        .btn-vault {
            background-color: var(--bank-navy);
            color: #ffffff;
            border: none;
            padding: 14px;
            font-weight: 700;
            width: 100%;
            border-radius: 8px;
            margin-top: 1.5rem;
            transition: all 0.2s ease;
        }

        .btn-vault:hover {
            background-color: #1e293b;
            transform: translateY(-1px);
            color: white;
        }

        .security-footer {
            margin-top: 2rem;
            text-align: center;
            font-size: 0.7rem;
            color: #94a3b8;
            font-weight: 600;
        }
    </style>
</head>
<body>

    <div class="login-card">
        <div class="bank-header">
            <h3>Secure Login</h3>
            <p>CoreBank Internal Systems</p>
        </div>

        <form action="bank-login" method="POST">
            <div class="mb-3">
                <label class="form-label">Username / Employee ID</label>
                <input type="text" name="uName" placeholder="e.g. C Mallikarjun" class="form-control" required>
            </div>

            <div class="mb-4">
                <label class="form-label">Vault Password</label>
                <input type="password" name="pwd" placeholder="••••••••" class="form-control" required>
            </div>

            <button type="submit" class="btn-vault">
                Access Secure Vault
            </button>
        </form>

        <div class="security-footer">
            🔒 256-BIT ENCRYPTION ACTIVE | BENGALURU NODE
        </div>
    </div>

</body>
</html>