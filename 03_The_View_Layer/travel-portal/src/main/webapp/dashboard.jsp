<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Flight Results | Travel Portal</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --travel-navy: #0f172a;
            --slate-600: #475569;
            --accent-blue: #3b82f6;
            --bg-soft: #f8fafc;
        }

        body {
            background-color: var(--bg-soft);
            font-family: 'Inter', -apple-system, sans-serif;
            color: var(--travel-navy);
            padding: 40px 0;
        }

        .results-container {
            max-width: 900px;
            margin: 0 auto;
        }

        .results-header {
            margin-bottom: 2rem;
            display: flex;
            justify-content: space-between;
            align-items: flex-end;
        }

        .results-header h3 {
            font-weight: 800;
            margin: 0;
            letter-spacing: -0.02em;
        }

        /* Modern Table Styling */
        .flight-table {
            background: #ffffff;
            border-radius: 12px;
            overflow: hidden;
            box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.05);
            border: 1px solid #e2e8f0;
        }

        .table thead {
            background-color: var(--travel-navy);
            color: #ffffff;
        }

        .table thead th {
            font-weight: 600;
            text-transform: uppercase;
            font-size: 0.75rem;
            letter-spacing: 0.05em;
            padding: 1.25rem;
            border: none;
        }

        .table tbody td {
            padding: 1.25rem;
            vertical-align: middle;
            color: var(--slate-600);
            border-bottom: 1px solid #f1f5f9;
        }

        .airline-name {
            color: var(--travel-navy);
            font-weight: 700;
        }

        .price-tag {
            color: var(--accent-blue);
            font-weight: 800;
            font-size: 1.1rem;
        }

        .btn-action {
            border: 1.5px solid var(--travel-navy);
            color: var(--travel-navy);
            font-weight: 700;
            padding: 10px 24px;
            border-radius: 8px;
            text-decoration: none;
            transition: all 0.2s;
        }

        .btn-action:hover {
            background-color: var(--travel-navy);
            color: #ffffff;
        }

        .empty-state {
            text-align: center;
            padding: 3rem;
            background: #ffffff;
            border-radius: 12px;
            color: var(--slate-600);
        }
    </style>
</head>
<body>

    <div class="container results-container">
        <div class="results-header">
            <div>
                <h3 style="color: var(--travel-navy);">Available Flights</h3>
                <p class="text-muted mb-0 small">Showing current best deals for your route.</p>
            </div>
            <a href="index.html" class="btn-action">New Search</a>
        </div>

        <div class="flight-table">
            <table class="table table-hover mb-0">
                <thead>
                    <tr>
                        <th>Airline Operator</th>
                        <th>Route/Destination</th>
                        <th class="text-end">Ticket Price</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${not empty flightList}">
                            <c:forEach items="${flightList}" var="f">
                                <tr>
                                    <td class="airline-name">
                                        ✈️ ${f.airline}
                                    </td>
                                    <td>
                                        ${f.destination}
                                    </td>
                                    <td class="text-end price-tag">
                                        ₹${f.ticketPrice}
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td colspan="3" class="empty-state">
                                    No flights found for this selection. Try different dates or routes.
                                </td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>

        <p class="mt-4 text-center small text-muted">
            Prices include all applicable taxes and fees.
        </p>
    </div>

</body>
</html>