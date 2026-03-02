<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Member Dashboard | Titan Fitness</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --gym-navy: #0f172a;
            --slate-500: #64748b;
            --active-green: #10b981;
            --bg-canvas: #f1f5f9;
        }

        body {
            background-color: var(--bg-canvas);
            font-family: 'Inter', -apple-system, sans-serif;
            color: var(--gym-navy);
            padding-top: 50px;
        }

        .profile-card {
            background: #ffffff;
            border-radius: 20px;
            overflow: hidden;
            border: 1px solid #e2e8f0;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.05);
        }

        .profile-header {
            background-color: var(--gym-navy);
            padding: 3rem 2rem;
            text-align: center;
            color: white;
        }

        .member-badge {
            display: inline-block;
            background: #eab308; /* Premium Gold */
            color: #422006;
            padding: 4px 14px;
            border-radius: 100px;
            font-size: 0.75rem;
            font-weight: 800;
            text-transform: uppercase;
            margin-bottom: 1rem;
        }

        .stat-grid {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 1px;
            background-color: #f1f5f9;
            border-top: 1px solid #f1f5f9;
            border-bottom: 1px solid #f1f5f9;
        }

        .stat-item {
            background: #ffffff;
            padding: 1.5rem;
            text-align: center;
        }

        .stat-label {
            display: block;
            font-size: 0.75rem;
            font-weight: 700;
            color: var(--slate-500);
            text-transform: uppercase;
            letter-spacing: 0.05em;
            margin-bottom: 0.5rem;
        }

        .stat-value {
            font-size: 1.25rem;
            font-weight: 800;
        }

        .status-pill {
            display: inline-flex;
            align-items: center;
            gap: 6px;
            color: var(--active-green);
        }

        .btn-renew {
            background-color: transparent;
            border: 2px solid var(--gym-navy);
            color: var(--gym-navy);
            padding: 14px;
            font-weight: 700;
            border-radius: 12px;
            width: 100%;
            transition: all 0.2s;
            margin-top: 2rem;
        }

        .btn-renew:hover {
            background-color: var(--gym-navy);
            color: #ffffff;
            transform: translateY(-2px);
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-5 col-md-7">
                <div class="profile-card">
                    <div class="profile-header">
                        <span class="member-badge">${userProfile.membershipType}</span>
                        <h2 class="fw-bold mb-1">${userProfile.name}</h2>
                        <p class="small opacity-75 mb-0">ID: TITAN-2026-8812</p>
                    </div>

                    <div class="card-body p-4">
                        <div class="stat-grid">
                            <div class="stat-item">
                                <span class="stat-label">Loyalty Points</span>
                                <span class="stat-value text-primary">${userProfile.loyaltyPoints}</span>
                            </div>
                            <div class="stat-item">
                                <span class="stat-label">Account Status</span>
                                <div class="stat-value status-pill">
                                    <div style="width: 8px; height: 8px; background: var(--active-green); border-radius: 50%;"></div>
                                    Active
                                </div>
                            </div>
                        </div>

                        <button class="btn-renew">
                            Renew Membership Plan
                        </button>

                        <p class="text-center mt-3 small text-muted">
                            Need help? <a href="#" class="text-decoration-none fw-bold" style="color: var(--gym-navy);">Contact Trainer</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>