<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Cart | ShopZen ERP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        :root {
            --shop-navy: #0f172a;
            --slate-500: #64748b;
            --border-soft: #e2e8f0;
            --bg-canvas: #f8fafc;
        }

        body {
            background-color: var(--bg-canvas);
            font-family: 'Inter', -apple-system, sans-serif;
            color: var(--shop-navy);
            padding-bottom: 50px;
        }

        .cart-card {
            background: #ffffff;
            border-radius: 12px;
            border: 1px solid var(--border-soft);
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.03);
            min-height: 350px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        .recently-viewed-card {
            background: #ffffff;
            border-radius: 12px;
            border-left: 5px solid var(--shop-navy);
            box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.05);
            position: sticky;
            top: 20px;
        }

        .label-text {
            font-size: 0.75rem;
            font-weight: 700;
            text-transform: uppercase;
            color: var(--slate-500);
            letter-spacing: 0.05em;
        }

        .item-display {
            font-size: 1.15rem;
            font-weight: 700;
            color: var(--shop-navy);
            margin: 0.75rem 0;
            padding: 10px;
            background: #f1f5f9;
            border-radius: 8px;
        }

        .cookie-badge {
            display: inline-flex;
            align-items: center;
            gap: 6px;
            color: #64748b;
            font-size: 0.75rem;
            font-weight: 600;
        }

        .btn-continue {
            background-color: var(--shop-navy);
            color: white;
            font-weight: 700;
            border-radius: 8px;
            padding: 12px 32px;
            text-decoration: none;
            transition: transform 0.2s, background 0.2s;
        }

        .btn-continue:hover {
            background-color: #1e293b;
            color: white;
            transform: translateY(-2px);
        }
    </style>
</head>
<body>

    <div class="container mt-5">
        <div class="row g-4">
            <div class="col-lg-8">
                <div class="cart-card p-5 text-center">
                    <div class="mb-4" style="color: #cbd5e1;">
                        <svg xmlns="http://www.w3.org/2000/svg" width="64" height="64" fill="currentColor" viewBox="0 0 16 16">
                            <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5z"/>
                        </svg>
                    </div>
                    <h2 class="fw-bold">Your shopping cart is empty</h2>
                    <p class="text-muted mb-4 fs-5">Pick up where you left off with your recently viewed items.</p>
                    <a href="electronics-store.jsp" class="btn-continue">Continue Shopping</a>
                </div>
            </div>

            <div class="col-lg-4">
                <div class="recently-viewed-card p-4">
                    <span class="label-text">Activity History</span>
                    <h5 class="fw-bold mt-1 mb-3">Recently Viewed</h5>

                    <%
                        Cookie[] cookies = request.getCookies();
                        String lastItem = null;
                        if (cookies != null) {
                            for (Cookie c : cookies) {
                                if ("lastViewed".equals(c.getName())) {
                                    lastItem = URLDecoder.decode(c.getValue(), "UTF-8");
                                }
                            }
                        }
                    %>

                    <% if (lastItem != null) { %>
                        <div class="item-display">
                            📦 <%= lastItem %>
                        </div>
                    <% } else { %>
                        <p class="text-muted small">No items tracked in this session.</p>
                    <% } %>

                    <div class="cookie-badge mt-2">
                        <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" fill="currentColor" class="bi bi-info-circle" viewBox="0 0 16 16">
                          <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                          <path d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
                        </svg>
                        Retrieved via browser cookies
                    </div>
                </div>

                <div class="mt-4 p-4 border-0 rounded-4 bg-white shadow-sm small">
                    <h6 class="fw-bold mb-2">Technical Summary</h6>
                    <p class="text-muted mb-0">
                        This module implements <strong>Client-Side Session Tracking</strong>. Unlike <code>HttpSession</code> which stores data on the server, Cookies store data directly on the user's machine, reducing server memory overhead for simple tracking tasks.
                    </p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>