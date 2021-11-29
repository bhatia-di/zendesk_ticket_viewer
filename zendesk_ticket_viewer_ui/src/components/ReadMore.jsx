import React, { useState } from "react";
import "../styles/index.css";


export default function ReadMore(readMoreProps)  {
  const text = readMoreProps.text;
  const [isReadMore, setIsReadMore] = useState(true);

  const toggleReadMore = () => {
    setIsReadMore(!isReadMore);
  };

  console.log(isReadMore);
  console.log(isReadMore ? text.slice(0, 50) : text);
  return (
    <p className="text">
      {isReadMore ? text.slice(0, 75) : text}
      <span onClick={() => {toggleReadMore()}} className="read-or-hide">
        {isReadMore ? "...read more" : " show less"}
      </span>
    </p>
  );
};