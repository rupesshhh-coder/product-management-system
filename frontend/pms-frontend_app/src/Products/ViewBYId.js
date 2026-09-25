import {useState} from "react";
import axios from "axios";
import { ViewById } from "../Services/ProductService";



export default function ViewProductById() {
    
const [id,setId]=useState();
const updateId=(e)=>{setId(e.target.value); setFlag(false)}

const [flag,setFlag]=useState(false);
const updateFlag=()=>{
setFlag(true);
}

const [product, setProduct]=useState();

//  const getProduct=(e)=>{
// e.preventDefault();
// axios.get("http://localhost:8080/pms/"+id)
// .then((res)=>{
// console.log(res.data);
// setProduct(ses.data);
// setFlag(true)

// .catch((err)=>{console.log(err)})

// }


const getProduct=(e)=>{
e.preventDefault();
ViewById(id)
.then((res)=>{
console.log(res.data);
setProduct(res.data);
setFlag(true)
})
.catch((err)=>{console.log(err)})
}


return<>
<h2>Serach product by id</h2>
<form onSubmit={getProduct}>


<table className="table table-sm">

<tr>
<td>Id</td>
<td><input type="text" onChange={updateId} ></input></td>
<td><input type="submit" value="View" className="btn bg-warning" ></input></td>
</tr>
</table>
</form>



{ flag &&
<ol>
<li>Id : {product.id}</li>
<li>Name : {product.name}</li>
<li>Category : {product.category}</li>
<li>Cost : {product.cost}</li>
<li>Quantity: {product.qty}</li>

</ol>

}

</>

}

