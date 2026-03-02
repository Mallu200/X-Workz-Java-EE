<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Property Search | X-Workz Real Estate</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --prop-navy: #0f172a;
            --slate-600: #475569;
            --accent-blue: #3b82f6;
            --bg-canvas: #f1f5f9;
        }

        body {
            background-color: var(--bg-canvas);
            font-family: 'Inter', -apple-system, sans-serif;
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            margin: 0;
            color: var(--prop-navy);
        }

        .hero-card {
            max-width: 650px;
            width: 90%;
            background: #ffffff;
            padding: 5rem 3rem;
            border-radius: 24px;
            box-shadow: 0 20px 25px -5px rgba(0, 0, 0, 0.1);
            text-align: center;
            border: 1px solid rgba(255, 255, 255, 0.3);
        }

        .location-tag {
            display: inline-block;
            background: #e0f2fe;
            color: #0369a1;
            padding: 6px 16px;
            border-radius: 100px;
            font-size: 0.8rem;
            font-weight: 700;
            text-transform: uppercase;
            letter-spacing: 0.1em;
            margin-bottom: 1.5rem;
        }

        .hero-card h1 {
            font-weight: 800;
            font-size: 2.75rem;
            letter-spacing: -0.025em;
            margin-bottom: 1rem;
            line-height: 1.1;
        }

        .hero-card p {
            color: var(--slate-600);
            font-size: 1.15rem;
            margin-bottom: 3rem;
            max-width: 80%;
            margin-left: auto;
            margin-right: auto;
        }

        .btn-view {
            background-color: var(--prop-navy);
            color: #ffffff;
            border: none;
            padding: 18px 40px;
            font-weight: 700;
            font-size: 1.1rem;
            border-radius: 12px;
            transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
            text-decoration: none;
            display: inline-block;
            box-shadow: 0 10px 15px -3px rgba(15, 23, 42, 0.2);
        }

        .btn-view:hover {
            background-color: #1e293b;
            transform: translateY(-3px);
            box-shadow: 0 20px 25px -5px rgba(15, 23, 42, 0.25);
            color: white;
        }

        .footer-links {
            margin-top: 3rem;
            display: flex;
            justify-content: center;
            gap: 20px;
            font-size: 0.85rem;
            font-weight: 600;
            color: #94a3b8;
        }
    </style>
</head>
<body>

    <div class="hero-card">
        <span class="location-tag">Premium Listings • Bengaluru</span>

        <h1>Find Your Dream Home</h1>
        <p>Explore exclusive villas, luxury apartments, and premium plots in the heart of the Silicon Valley of India.</p>

        <a href="view-property" class="btn-view">
            View Property Details
        </a>

        <div class="footer-links">
            <span>Verified Agents</span>
            <span>•</span>
            <span>0% Brokerage</span>
            <span>•</span>
            <span>Instant Site Visits</span>
        </div>
    </div>

</body>
</html>