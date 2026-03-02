<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Travel Search | Explore India</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --travel-navy: #0f172a;
            --slate-500: #64748b;
            --sky-blue: #f0f9ff;
            --border-soft: #e2e8f0;
        }

        body {
            background-color: var(--sky-blue);
            font-family: 'Inter', -apple-system, sans-serif;
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            margin: 0;
            color: var(--travel-navy);
        }

        .search-card {
            max-width: 600px;
            width: 90%;
            background: #ffffff;
            padding: 4rem 2rem;
            border-radius: 20px;
            box-shadow: 0 20px 25px -5px rgba(0, 0, 0, 0.05);
            border: 1px solid var(--border-soft);
            text-align: center;
        }

        .icon-box {
            color: var(--travel-navy);
            margin-bottom: 1.5rem;
        }

        .search-card h2 {
            font-weight: 800;
            font-size: 2.25rem;
            letter-spacing: -0.025em;
            margin-bottom: 0.75rem;
        }

        .search-card p {
            color: var(--slate-500);
            font-size: 1.1rem;
            margin-bottom: 2.5rem;
        }

        .btn-search {
            background-color: var(--travel-navy);
            color: #ffffff;
            border: none;
            padding: 16px 48px;
            font-weight: 700;
            font-size: 1.1rem;
            border-radius: 12px;
            transition: all 0.3s ease;
            box-shadow: 0 4px 12px rgba(15, 23, 42, 0.15);
        }

        .btn-search:hover {
            background-color: #1e293b;
            transform: translateY(-2px);
            box-shadow: 0 8px 20px rgba(15, 23, 42, 0.2);
            color: white;
        }

        .badge-india {
            display: inline-block;
            background: #f1f5f9;
            color: #475569;
            padding: 6px 16px;
            border-radius: 100px;
            font-size: 0.8rem;
            font-weight: 700;
            text-transform: uppercase;
            letter-spacing: 0.05em;
            margin-bottom: 1rem;
        }
    </style>
</head>
<body>

    <div class="search-card">
        <div class="icon-box">
            <svg xmlns="http://www.w3.org/2000/svg" width="48" height="48" fill="currentColor" class="bi bi-airplane-engines" viewBox="0 0 16 16">
                <path d="M8 0c-.176 0-.352.006-.527.017l1.35 4.843A1.5 1.5 0 0 1 10.5 6.5V9l4.5 1.5v1.5l-4.5-1.5v2.586l1 1V15l-3-1-3 1v-1.414l1-1V10.5L1 9V7.5L5.5 9V6.5a1.5 1.5 0 0 1 1.677-1.64L8.527.017A10.5 10.5 0 0 0 8 0z"/>
            </svg>
        </div>

        <span class="badge-india">Domestic Travel India</span>
        <h2>Where to next?</h2>
        <p>Discover the best airfare deals for your next adventure across the subcontinent.</p>

        <form action="search-flights" method="GET">
            <button type="submit" class="btn-search">
                Search Flights
            </button>
        </form>
    </div>

</body>
</html>