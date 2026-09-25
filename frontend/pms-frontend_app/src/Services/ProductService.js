import axios from "axios";
const URI="http://localhost:8080/pms";

export const ViewById=(id)=>{ return axios.get(URI+"/"+id);}

export const UpdateProductService=(id,product)=>{ return axios.put(URI+"/"+id,product);}

export const DeleteProductService=(id)=>{ return axios.delete(URI+"/"+id)}

