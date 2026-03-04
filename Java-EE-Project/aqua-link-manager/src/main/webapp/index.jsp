<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AquaLink | Connection Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --aqua-deep: #006097; /* Professional Water Deep Blue */
            --aqua-light: #e0f2fe; /* Soft Sky Water Blue */
            --aqua-accent: #0ea5e9; /* Vibrant Water Blue */
            --slate-gray: #475569;
            --bg-canvas: #f0f9ff;
        }

        body {
            background-color: var(--bg-canvas);
            font-family: 'Inter', -apple-system, sans-serif;
            color: #0f172a;
            min-height: 100vh;
            display: flex;
            align-items: center;
        }

        .reg-card {
            background: #ffffff;
            border-radius: 20px;
            overflow: hidden;
            border: 1px solid #bae6fd;
            box-shadow: 0 15px 35px rgba(0, 96, 151, 0.1);
        }

        .aqua-header {
            background: linear-gradient(135deg, var(--aqua-deep), var(--aqua-accent));
            padding: 2.5rem 2rem;
            text-align: center;
            color: white;
        }

        .aqua-header h2 {
            font-weight: 800;
            letter-spacing: -0.5px;
            margin-bottom: 0.5rem;
        }

        .aqua-header p {
            font-size: 0.9rem;
            opacity: 0.9;
            margin-bottom: 0;
        }

        .form-label {
            font-size: 0.8rem;
            font-weight: 700;
            color: var(--slate-gray);
            text-transform: uppercase;
            letter-spacing: 0.025em;
            margin-bottom: 0.5rem;
        }

        .form-control, .form-select {
            border: 1.5px solid #e2e8f0;
            padding: 12px;
            border-radius: 10px;
            background-color: #f8fafc;
            transition: all 0.2s;
        }

        .form-control:focus {
            background-color: #ffffff;
            border-color: var(--aqua-accent);
            box-shadow: 0 0 0 4px rgba(14, 165, 233, 0.1);
            outline: none;
        }

        .btn-register {
            background-color: var(--aqua-deep);
            border: none;
            color: white;
            padding: 14px;
            font-weight: 700;
            border-radius: 10px;
            transition: all 0.3s;
        }

        .btn-register:hover {
            background-color: #004a75;
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(0, 96, 151, 0.2);
        }

        .btn-view {
            color: var(--aqua-deep);
            background: var(--aqua-light);
            font-weight: 700;
            padding: 14px;
            border-radius: 10px;
            text-decoration: none;
            display: inline-block;
            text-align: center;
            transition: all 0.2s;
        }

        .btn-view:hover {
            background: #bae6fd;
            color: var(--aqua-deep);
        }

        .success-banner {
            background: #dcfce7;
            color: #166534;
            padding: 12px;
            border-radius: 8px;
            font-weight: 600;
            margin-bottom: 2rem;
            border-left: 4px solid #22c55e;
            text-align: center;
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-6 col-md-8">
                <div class="reg-card">
                    <div class="aqua-header">
                        <h2> AquaLink</h2>
                        <p>Municipal Water Management System</p>
                    </div>

                    <div class="card-body p-4 p-md-5">
                        <c:if test="${not empty msg}">
                            <div class="success-banner">
                                ${msg}
                            </div>
                        </c:if>

                        <form action="${pageContext.request.contextPath}/register" method="post">
                            <div class="row g-3">
                                <div class="col-12">
                                    <label class="form-label">Consumer Full Name</label>
                                    <input type="text" name="consumerName" class="form-control" placeholder="John Doe" required>
                                </div>

                                <div class="col-md-6">
                                    <label class="form-label">Meter Number</label>
                                    <input type="text" name="meterNumber" class="form-control" placeholder="AQ-12345" required>
                                </div>

                                <div class="col-md-6">
                                    <label class="form-label">Current Reading (kL)</label>
                                    <input type="number" step="0.1" name="currentReading" class="form-control" placeholder="0.0">
                                </div>

                                <div class="col-12">
                                    <label class="form-label">Connection Category</label>
                                    <select name="type" class="form-select">
                                        <option value="RESIDENTIAL">Residential</option>
                                        <option value="COMMERCIAL">Commercial</option>
                                        <option value="INDUSTRIAL">Industrial</option>
                                    </select>
                                </div>

                                <div class="col-12 mt-4">
                                    <div class="d-grid gap-2">
                                        <button type="submit" class="btn-register">Register New Connection</button>
                                        <a href="viewAll" class="btn-view">View All Records</a>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <p class="text-center mt-4 text-muted small">
                    Official Portal for Raichur Water Supply Operations
                </p>
            </div>
        </div>
    </div>

</body>
</html>