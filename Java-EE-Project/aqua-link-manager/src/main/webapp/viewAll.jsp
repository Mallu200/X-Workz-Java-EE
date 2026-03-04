<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AquaLink | Connection Records</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --aqua-deep: #006097;
            --aqua-accent: #0ea5e9;
            --bg-canvas: #f8fafc;
            --slate-300: #cbd5e1;
        }

        body {
            background-color: var(--bg-canvas);
            font-family: 'Inter', -apple-system, sans-serif;
            color: #1e293b;
            padding: 40px 0;
        }

        .dashboard-container {
            background: #ffffff;
            border-radius: 20px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.05);
            border: 1px solid #e2e8f0;
            overflow: hidden;
        }

        .header-section {
            background: linear-gradient(90deg, var(--aqua-deep), var(--aqua-accent));
            padding: 2rem;
            color: white;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .table-wrapper {
            padding: 1.5rem;
        }

        .table thead th {
            background-color: #f1f5f9;
            color: #64748b;
            text-transform: uppercase;
            font-size: 0.75rem;
            font-weight: 800;
            letter-spacing: 0.05em;
            border-top: none;
            padding: 1rem;
        }

        .table tbody td {
            padding: 1rem;
            vertical-align: middle;
            font-size: 0.95rem;
            border-bottom: 1px solid #f1f5f9;
        }

        .type-badge {
            font-size: 0.7rem;
            font-weight: 700;
            padding: 4px 10px;
            border-radius: 100px;
            text-transform: uppercase;
        }

        .badge-residential { background: #dcfce7; color: #166534; }
        .badge-commercial { background: #fef9c3; color: #854d0e; }
        .badge-industrial { background: #fee2e2; color: #991b1b; }

        .btn-action {
            font-weight: 600;
            font-size: 0.8rem;
            border-radius: 8px;
            padding: 6px 14px;
            transition: all 0.2s;
        }

        .nav-link-custom {
            color: white;
            text-decoration: none;
            font-weight: 600;
            font-size: 0.9rem;
            display: flex;
            align-items: center;
            gap: 8px;
        }

        .nav-link-custom:hover {
            color: #bae6fd;
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="dashboard-container">
            <div class="header-section">
                <div>
                    <h2 class="fw-bold mb-0">Connection Records</h2>
                    <p class="mb-0 opacity-75 small">Live database of active municipal meters</p>
                </div>
                <a href="index.jsp" class="nav-link-custom">
                    <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" viewBox="0 0 16 16">
                        <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                    </svg>
                    Add New Connection
                </a>
            </div>

            <div class="table-wrapper">
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Ref ID</th>
                                <th>Consumer Name</th>
                                <th>Meter Number</th>
                                <th>Reading (kL)</th>
                                <th>Category</th>
                                <th class="text-center">Operations</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${connections}" var="conn">
                                <tr>
                                    <td class="fw-bold text-muted">#${conn.id}</td>
                                    <td class="fw-semibold">${conn.consumerName}</td>
                                    <td>
                                        <code class="text-primary fw-bold">${conn.meterNumber}</code>
                                    </td>
                                    <td>${conn.currentReading}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${conn.type == 'RESIDENTIAL'}">
                                                <span class="type-badge badge-residential">Residential</span>
                                            </c:when>
                                            <c:when test="${conn.type == 'COMMERCIAL'}">
                                                <span class="type-badge badge-commercial">Commercial</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="type-badge badge-industrial">Industrial</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td class="text-center">
                                        <a href="update?id=${conn.id}" class="btn btn-outline-primary btn-action me-1">Edit</a>
                                        <a href="delete?id=${conn.id}" class="btn btn-outline-danger btn-action" onclick="return confirm('Confirm permanent deletion?')">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <p class="text-center mt-4 text-muted small">
            &copy; 2026 AquaLink Systems • Raichur Division
        </p>
    </div>

</body>
</html>