import * as React from "react";
import { Route } from 'react-router-dom';
import PostCards from "./components/PostCards";

export default [
    <Route exact path="/baz" component={PostCards} />,
];