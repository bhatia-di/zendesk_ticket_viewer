import React, { useState } from "react";
import {Badge} from 'reactstrap';

export default function TypeBadge(typeBadgeProps) {
 //"problem", "incident", "question", or "task".

 const renderBadge = (type) => {

    switch (type) {

        case "problem" : return <Badge color="warning" pill> {type} </Badge>

        case "hold":
        case "incident" : return <Badge color="danger" pill> {type} </Badge>

        case "pending":
        case "question" : return <Badge color="dark" pill> {type} </Badge>

        case "new":
        case "open":
        case "task" : return <Badge color="primary" pill> {type} </Badge>

        case "closed":
        case "solved" : return <Badge color="success" pill> {type} </Badge>
        default: return <Badge pill> {type} </Badge>



    }


 }


 if (typeBadgeProps.type == null) return null;
 if (typeBadgeProps.typeBadge == "tag") return <span className={"p-1"}><Badge color="dark" pill> {typeBadgeProps.type} </Badge></span>
 return (
      <span className={"m-1 p-1"}>{ renderBadge(typeBadgeProps.type) }</span>
    );







}