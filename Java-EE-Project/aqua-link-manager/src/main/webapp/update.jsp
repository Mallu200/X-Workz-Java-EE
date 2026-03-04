<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AquaLink | Modify Connection</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --aqua-deep: #006097;
            --aqua-accent: #0ea5e9;
            --warning-amber: #f59e0b;
            --bg-canvas: #f8fafc;
        }

        body {
            background-color: var(--bg-canvas);
            font-family: 'Inter', -apple-system, sans-serif;
            color: #1e293b;
            min-height: 100vh;
            display: flex;
            align-items: center;
        }

        .update-card {
            background: #ffffff;
            border-radius: 20px;
            overflow: hidden;
            border: 1px solid #e2e8f0;
            box-shadow: 0 20px 25px -5px rgba(0, 0, 0, 0.05);
        }

        .update-header {
            background-color: var(--aqua-deep);
            padding: 2rem;
            color: white;
            text-align: center;
        }

        .id-badge {
            background: rgba(255, 255, 255, 0.2);
            padding: 4px 12px;
            border-radius: 100px;
            font-size: 0.8rem;
            font-weight: 700;
            margin-bottom: 0.5rem;
            display: inline-block;
        }

        .form-label {
            font-size: 0.8rem;
            font-weight: 700;
            color: #64748b;
            text-transform: uppercase;
            letter-spacing: 0.05em;
        }

        .form-control:read-only {
            background-color: #f1f5f9;
            border-color: #e2e8f0;
            color: #94a3b8;
            cursor: not-allowed;
        }

        .btn-update {
            background-color: var(--warning-amber);
            border: none;
            color: white;
            padding: 12px;
            font-weight: 700;
            border-radius: 10px;
            transition: all 0.2s;
        }

        .btn-update:hover {
            background-color: #d97706;
            transform: translateY(-1px);
            box-shadow: 0 4px 12px rgba(245, 158, 11, 0.2);
        }

        .btn-cancel {
            background-color: #f1f5f9;
            color: #475569;
            border: none;
            padding: 12px;
            font-weight: 700;
            border-radius: 10px;
            text-decoration: none;
            display: inline-block;
            text-align: center;
        }

        .btn-cancel:hover {
            background-color: #e2e8f0;
            color: #1e293b;
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-5 col-md-7">
                <div class="update-card">
                    <div class="update-header">
                        <span class="id-badge">RECORD REF: #${connection.id}</span>
                        <h3 class="fw-bold mb-0">Modify Connection</h3>
                    </div>

                    <div class="card-body p-4 p-md-5">
                        <form action="updateData" method="post">
                            <input type="hidden" name="id" value="${connection.id}">

                            <div class="mb-3">
                                <label class="form-label">Consumer Name</label>
                                <input type="text" name="consumerName" value="${connection.consumerName}" class="form-control" required>
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Meter Number (Non-Editable)</label>
                                <input type="text" name="meterNumber" value="${connection.meterNumber}" class="form-control" readonly>
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Current Reading (kL)</label>
                                <input type="number" step="0.1" name="currentReading" value="${connection.currentReading}" class="form-control">
                            </div>

                            <div class="mb-4">
                                <label class="form-label">Category</label>
                                <select name="type" class="form-select">
                                    <option value="RESIDENTIAL" ${connection.type == 'RESIDENTIAL' ? 'selected' : ''}>Residential</option>
                                    <option value="COMMERCIAL" ${connection.type == 'COMMERCIAL' ? 'selected' : ''}>Commercial</option>
                                    <option value="INDUSTRIAL" ${connection.type == 'INDUSTRIAL' ? 'selected' : ''}>Industrial</option>
                                </select>
                            </div>

                            <div class="d-grid gap-2">
                                <button type="submit" class="btn-update">Save Updated Records</button>
                                <a href="viewAll" class="btn-cancel">Cancel and Return</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>