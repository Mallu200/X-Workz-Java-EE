<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout | ShopZen E-Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --zen-navy: #0f172a;
            --slate-600: #475569;
            --border-soft: #e2e8f0;
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
        }

        .checkout-card {
            max-width: 400px;
            width: 90%;
            background: #ffffff;
            padding: 2.5rem;
            border-radius: 12px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.05);
            border: 1px solid var(--border-soft);
        }

        .shopzen-logo {
            color: var(--zen-navy);
            font-weight: 800;
            text-align: center;
            margin-bottom: 0.5rem;
            letter-spacing: -1px;
        }

        .checkout-header {
            text-align: center;
            font-size: 0.9rem;
            color: var(--slate-600);
            margin-bottom: 2rem;
            font-weight: 500;
        }

        .form-label {
            font-size: 0.75rem;
            font-weight: 700;
            text-transform: uppercase;
            color: var(--slate-600);
            margin-bottom: 0.5rem;
            display: block;
        }

        .form-control {
            border: 1.5px solid var(--border-soft);
            padding: 12px;
            border-radius: 8px;
            background-color: #ffffff;
            font-size: 1rem;
            transition: all 0.2s ease;
        }

        .form-control:focus {
            border-color: var(--zen-navy);
            box-shadow: 0 0 0 4px rgba(15, 23, 42, 0.05);
            outline: none;
        }

        .btn-purchase {
            background-color: var(--zen-navy);
            color: #ffffff;
            border: none;
            padding: 14px;
            font-weight: 600;
            width: 100%;
            border-radius: 8px;
            margin-top: 1rem;
            transition: background 0.2s, transform 0.1s;
            letter-spacing: 0.5px;
        }

        .btn-purchase:hover {
            background-color: #1e293b;
            transform: translateY(-1px);
        }

        .secure-note {
            text-align: center;
            margin-top: 1.5rem;
            font-size: 0.75rem;
            color: #94a3b8;
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 5px;
        }
    </style>
</head>
<body>

    <div class="checkout-card">
        <h2 class="shopzen-logo">ShopZen</h2>
        <p class="checkout-header">Order Summary & Checkout</p>

        <form action="process-order" method="POST">
            <div class="mb-3">
                <label class="form-label">Product Name</label>
                <input type="text" name="pName" placeholder="Item in cart" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Total Price (USD)</label>
                <div class="input-group">
                    <span class="input-group-text bg-white border-end-0" style="border: 1.5px solid var(--border-soft); border-radius: 8px 0 0 8px;">$</span>
                    <input type="number" name="pPrice" placeholder="0.00" class="form-control border-start-0" style="border-radius: 0 8px 8px 0;" required>
                </div>
            </div>

            <button type="submit" class="btn-purchase">
                Complete Purchase
            </button>
        </form>

        <div class="secure-note">
            <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" viewBox="0 0 16 16">
                <path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z"/>
            </svg>
            Secure SSL Encrypted Checkout
        </div>
    </div>

</body>
</html>