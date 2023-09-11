import React from 'react'
import { Link, useNavigate } from 'react-router-dom';

function Navbar() {
  return (
     <nav class="navbar navbar-expand-lg navbar-dark bg-dark bg-body">
      <div class="container-fluid">
        <a class="navbar-brand font-weight-bold " href="/">BOOK MANAGEMENT SYSTEM</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="/">HOME</a>
            </li>
            <li class="nav-item active">
              
              <Link to='/create' className='nav-link'>ADD +</Link>
            </li>
            
          </ul>
        </div>
      </div>
    </nav>
  )
}

export default Navbar