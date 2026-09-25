import logo from './logo.svg';
import './App.css';
import ViewAllProduct from './Products/ViewAll';
import CreateProduct from './Products/Create';
import UpdateProduct from './Products/Update';
import DeleteProduct from './Products/Delete';
import {BrowserRouter,Route,Routes} from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import {Container,Nav,Navbar} from "react-bootstrap";
import ViewProductById from './Products/ViewBYId';

function App() {
  return (
    <div className="App">
      

     <Navbar bg="success" data-bs-theme="dark">
        <Container>

          <Navbar.Brand href="/">Product</Navbar.Brand>

          <Nav className="me-auto">
            <Nav.Link href="/create">Register</Nav.Link>
            <Nav.Link href="Product">View By ID</Nav.Link>
            <Nav.Link href="/update">UpdateProduct</Nav.Link>
            <Nav.Link href="/delete">Delete</Nav.Link>

          </Nav>
        </Container>
      </Navbar>


      <BrowserRouter>
        <Routes>

          <Route element={<ViewAllProduct></ViewAllProduct>} path="/"></Route>
          <Route element={<CreateProduct></CreateProduct>} path="/create"></Route>
          <Route element={<UpdateProduct></UpdateProduct>} path="/update"></Route>
          <Route element={<DeleteProduct></DeleteProduct>} path="/delete"></Route>
          <Route element={<ViewProductById></ViewProductById>} path="/product"></Route>

        </Routes>
      </BrowserRouter>


    </div>
  );
}

export default App;
