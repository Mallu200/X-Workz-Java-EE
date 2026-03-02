<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Property Details | X-Workz Real Estate</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --prop-navy: #0f172a;
            --slate-600: #475569;
            --accent-gold: #b45309; /* Subtle gold for premium feel */
            --bg-canvas: #f8fafc;
        }

        body {
            background-color: var(--bg-canvas);
            font-family: 'Inter', -apple-system, sans-serif;
            color: var(--prop-navy);
            margin: 0;
        }

        /* Premium Navbar */
        .navbar-custom {
            background-color: var(--prop-navy);
            padding: 1rem 0;
            box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);
        }

        .navbar-brand {
            font-size: 1.25rem;
            letter-spacing: -0.5px;
        }

        .nav-link-custom {
            color: rgba(255, 255, 255, 0.8);
            text-decoration: none;
            font-size: 0.9rem;
            font-weight: 500;
            transition: color 0.2s;
        }

        .nav-link-custom:hover {
            color: #ffffff;
        }

        /* Property Card */
        .property-card {
            background: #ffffff;
            border-radius: 16px;
            overflow: hidden;
            border: 1px solid #e2e8f0;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.05);
            margin-top: 40px;
        }

        .card-body-main {
            padding: 3rem;
        }

        .prop-id-badge {
            display: inline-block;
            background: #f1f5f9;
            color: var(--slate-600);
            padding: 4px 12px;
            border-radius: 6px;
            font-size: 0.75rem;
            font-weight: 700;
            text-transform: uppercase;
            margin-bottom: 1.5rem;
        }

        .prop-title {
            font-weight: 800;
            font-size: 2rem;
            letter-spacing: -0.02em;
            margin-bottom: 0.5rem;
        }

        .prop-location {
            display: flex;
            align-items: center;
            gap: 6px;
            color: var(--slate-600);
            font-size: 1rem;
            margin-bottom: 2rem;
        }

        .price-tag {
            font-size: 1.75rem;
            font-weight: 800;
            color: var(--prop-navy);
            margin-bottom: 1.5rem;
        }

        .description-box {
            line-height: 1.7;
            color: var(--slate-600);
            font-size: 1.05rem;
            border-top: 1px solid #f1f5f9;
            padding-top: 1.5rem;
            margin-top: 1.5rem;
        }

        /* Booking Button */
        .btn-visit {
            background-color: var(--prop-navy);
            color: #ffffff;
            border: none;
            padding: 16px;
            font-weight: 700;
            border-radius: 10px;
            width: 100%;
            margin-top: 2rem;
            transition: all 0.3s ease;
        }

        .btn-visit:hover {
            background-color: #1e293b;
            transform: translateY(-2px);
            box-shadow: 0 8px 15px rgba(15, 23, 42, 0.1);
            color: #ffffff;
        }
    </style>
</head>
<body>

    <nav class="navbar-custom">
        <div class="container d-flex justify-content-between align-items-center">
            <a class="navbar-brand fw-bold text-white text-decoration-none" href="index.html">🏢 X-WORKZ REAL ESTATE</a>
            <div class="d-none d-md-flex gap-4">
                <a href="#" class="nav-link-custom">Buy</a>
                <a href="#" class="nav-link-custom">Rent</a>
                <a href="#" class="nav-link-custom">List Property</a>
                <a href="#" class="nav-link-custom">Contact</a>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="row">
            <div class="col-lg-8 mx-auto">
                <div class="property-card">
                    <div class="card-body-main">
                        <span class="prop-id-badge">Verified Listing • ID: #7742</span>

                        <h1 class="prop-title">${property.title}</h1>

                        <div class="prop-location">
                            <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" viewBox="0 0 16 16">
                                <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z"/>
                            </svg>
                            ${property.location}
                        </div>

                        <div class="price-tag">
                            ₹${property.price}
                        </div>

                        <div class="description-box">
                            <strong>About this property:</strong><br>
                            Experience premium living with modern amenities in a prime location. This property features a spacious floor plan, high-quality finishes, and convenient access to local infrastructure.
                        </div>

                        <button class="btn-visit">
                            Schedule a Site Visit
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>