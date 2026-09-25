
import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { UpdateProductService, ViewById } from "../Services/ProductService";
export default function UpdateProduct()
{
const [pid,setPId]=useState();

const updateEId=(e)=>{
setPId(e.target.value);
}

const [id,setId]=useState();
const [name, setName]=useState();
const [cost,setCost]=useState();
const [category, setCategory]=useState();
const [qty,setQty]=useState();

const updateId=(e)=>{
setId(e.target.value);
}

const updateName=(e)=>{
setName(e.target.value);
}

const updateCost=(e)=>{
setCost(e.target.value);
}

const updateCategory=(e)=>{
setCategory(e.target.value);
}

const updateQty=(e)=>{
    setQty(e.target.value);
}


const viewProduct=(e)=>{
e.preventDefault();
ViewById(pid)
.then((res)=>{
    setId(res.data.id);
    setName(res.data.name);
    setCost(res.data.cost);
    setCategory(res.data.category);
    setQty(res.data.qty);

})

.catch(err=>console.log(err))

}


const nav=useNavigate();
const handleSubmit=(e)=>{
e.preventDefault();

let p={
id, name, cost, category, qty

};

UpdateProductService(pid,p)
.then((res)=>{
console.log(res.data );
nav("/");
})

.catch(err=>console.log(err))
}


return<>

<h2>Update Product</h2>
<form onSubmit={handleSubmit}>
<table className="table table-sm">

<tr>
<td>Serach Id</td>
<td><input type="text" onChange={updateEId}></input></td>
<td><input type="button" value="View" className="btn bg-warning" onClick={viewProduct}></input></td>
</tr>

<tr>
<td>Id</td>
<td><input type="text" readOnly value={id}></input></td>
</tr>

<tr>
<td>Name</td>
<td><input type="text" onChange={updateName} value={name}></input></td>
</tr>

<tr>
<td>Cost</td>
<td><input type="text" onChange={updateCost} value={cost}></input></td>
</tr>

<tr>
<td>Category</td>
<td><input type="text" onChange={updateCategory} value={category}></input></td>
</tr>
<tr>

<td>Quantity</td>
<td><input type="text" onChange={updateQty} value={qty}></input></td>
</tr>

<tr>
<td><input type="reset" className="btn bg-danger"></input></td>
<td><input type="submit" value="Update" className="btn bg-success"></input></td>
</tr>

</table>

</form>

</>

}




