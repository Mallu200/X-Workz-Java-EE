<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Confirmed | ShopZen</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --zen-navy: #0f172a;
            --slate-500: #64748b;
            --success-green: #10b981;
            --bg-soft: #f8fafc;
            --border-color: #e2e8f0;
        }

        body {
            background-color: var(--bg-soft);
            font-family: 'Inter', -apple-system, sans-serif;
            margin: 0;
            color: var(--zen-navy);
        }

        /* Navbar Styling */
        .shop-nav {
            background-color: var(--zen-navy);
            padding: 1rem 0;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }

        .receipt-container {
            display: flex;
            justify-content: center;
            padding: 60px 20px;
        }

        .receipt-card {
            max-width: 480px;
            width: 100%;
            background: #ffffff;
            border-radius: 20px;
            box-shadow: 0 25px 50px -12px rgba(0, 0, 0, 0.08);
            overflow: hidden;
            border: 1px solid var(--border-color);
        }

        .status-header {
            background-color: var(--zen-navy);
            color: white;
            padding: 3rem 2rem;
            text-align: center;
            position: relative;
        }

        /* Success Icon */
        .check-circle {
            width: 64px;
            height: 64px;
            background: var(--success-green);
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 0 auto 1.25rem;
            box-shadow: 0 0 20px rgba(16, 185, 129, 0.4);
        }

        .order-body {
            padding: 2.5rem;
        }

        .order-title {
            font-size: 0.75rem;
            font-weight: 700;
            text-transform: uppercase;
            letter-spacing: 0.1em;
            color: var(--slate-500);
            margin-bottom: 1.5rem;
            border-bottom: 2px solid var(--bg-soft);
            padding-bottom: 0.5rem;
        }

        .info-row {
            display: flex;
            justify-content: space-between;
            margin-bottom: 1.25rem;
        }

        .info-label {
            color: var(--slate-500);
            font-size: 0.95rem;
        }

        .info-value {
            font-weight: 600;
            text-align: right;
        }

        /* Total Section */
        .total-box {
            background: var(--bg-soft);
            padding: 1.25rem;
            border-radius: 12px;
            margin-top: 2rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .total-label {
            font-weight: 700;
            font-size: 1rem;
        }

        .total-price {
            font-size: 1.5rem;
            font-weight: 800;
            color: var(--success-green);
        }

        .btn-continue {
            display: block;
            width: 100%;
            padding: 14px;
            margin-top: 2rem;
            background-color: var(--zen-navy);
            color: white;
            text-align: center;
            text-decoration: none;
            font-weight: 700;
            border-radius: 10px;
            transition: all 0.2s ease;
        }

        .btn-continue:hover {
            background-color: #1e293b;
            transform: translateY(-2px);
            color: white;
        }

        .receipt-footer {
            text-align: center;
            font-size: 0.8rem;
            color: var(--slate-500);
            margin-top: 1.5rem;
        }
    </style>
</head>
<body>

    <nav class="shop-nav">
        <div class="container text-center">
            <span class="text-white fw-bold h5 mb-0">SHOPZEN</span>
        </div>
    </nav>

    <div class="receipt-container">
        <div class="receipt-card">
            <div class="status-header">
                <div class="check-circle">
                    <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="white" viewBox="0 0 16 16">
                        <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"/>
                    </svg>
                </div>
                <h3 class="fw-bold mb-1">Order Confirmed!</h3>
                <p class="small mb-0 opacity-75">Your transaction was successful.</p>
            </div>

            <div class="order-body">
                <div class="order-title">Summary</div>

                <div class="info-row">
                    <span class="info-label">Transaction ID</span>
                    <span class="info-value">#${item.orderId}</span>
                </div>

                <div class="info-row">
                    <span class="info-label">Item Purchased</span>
                    <span class="info-value">${item.productName}</span>
                </div>

                <div class="total-box">
                    <span class="total-label">Paid Amount</span>
                    <span class="total-price">₹${item.price}</span>
                </div>

                <a href="index.jsp" class="btn-continue">
                    Continue Shopping
                </a>

                <div class="receipt-footer">
                    A digital invoice has been sent to your email.
                </div>
            </div>
        </div>
    </div>

</body>
</html>