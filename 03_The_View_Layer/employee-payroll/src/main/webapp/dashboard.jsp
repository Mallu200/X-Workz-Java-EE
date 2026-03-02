<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payroll Dashboard | CorpConnect</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --corp-navy: #0f172a;
            --slate-600: #475569;
            --success-bg: #f0fdf4;
            --success-text: #166534;
            --pending-bg: #fef2f2;
            --pending-text: #991b1b;
            --bg-light: #f8fafc;
        }

        body {
            background-color: var(--bg-light);
            font-family: 'Inter', -apple-system, system-ui, sans-serif;
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            margin: 0;
            color: var(--corp-navy);
        }

        .dashboard-card {
            max-width: 500px;
            width: 90%;
            background: #ffffff;
            border-radius: 12px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.05);
            border: 1px solid #e2e8f0;
            overflow: hidden;
        }

        .card-accent {
            height: 6px;
            background-color: var(--corp-navy);
        }

        .card-body {
            padding: 2.5rem;
        }

        .header-section {
            border-bottom: 2px solid var(--bg-light);
            padding-bottom: 1.5rem;
            margin-bottom: 1.5rem;
        }

        .emp-name {
            font-size: 1.25rem;
            font-weight: 800;
            margin-bottom: 0.25rem;
        }

        .label-text {
            font-size: 0.75rem;
            font-weight: 700;
            text-transform: uppercase;
            letter-spacing: 0.05em;
            color: var(--slate-600);
            display: block;
        }

        .salary-display {
            font-size: 1.75rem;
            font-weight: 700;
            color: var(--corp-navy);
            margin: 0.5rem 0 1.5rem 0;
        }

        /* Modern Status Banners */
        .status-banner {
            padding: 1rem;
            border-radius: 8px;
            display: flex;
            align-items: center;
            gap: 12px;
            font-weight: 600;
            margin-bottom: 2rem;
        }

        .status-success {
            background-color: var(--success-bg);
            color: var(--success-text);
            border: 1px solid #bbf7d0;
        }

        .status-pending {
            background-color: var(--pending-bg);
            color: var(--pending-text);
            border: 1px solid #fecaca;
        }

        .btn-return {
            background-color: transparent;
            border: 2.2px solid var(--corp-navy);
            color: var(--corp-navy);
            padding: 12px;
            font-weight: 700;
            width: 100%;
            border-radius: 8px;
            text-decoration: none;
            display: block;
            text-align: center;
            transition: all 0.2s;
        }

        .btn-return:hover {
            background-color: var(--corp-navy);
            color: #ffffff;
        }
    </style>
</head>
<body>

    <div class="dashboard-card">
        <div class="card-accent"></div>
        <div class="card-body">
            <div class="header-section">
                <span class="label-text">Employee Statement</span>
                <h4 class="emp-name">${employee.name}</h4>
            </div>

            <span class="label-text">Net Salary Disbursable</span>
            <h2 class="salary-display">₹${employee.salary}</h2>

            <c:choose>
                <c:when test="${employee.paid}">
                    <div class="status-banner status-success">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" viewBox="0 0 16 16">
                            <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                        </svg>
                        Salary Disbursed Successfully
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="status-banner status-pending">
                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" viewBox="0 0 16 16">
                            <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.75-13.5v7a.75.75 0 0 1-1.5 0v-7a.75.75 0 0 1 1.5 0zM9 11a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
                        </svg>
                        Pending Finance Approval
                    </div>
                </c:otherwise>
            </c:choose>

            <a href="index.jsp" class="btn-return">Search Another Employee</a>
        </div>
    </div>

</body>
</html>