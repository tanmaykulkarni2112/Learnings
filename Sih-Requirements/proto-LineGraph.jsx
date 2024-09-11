// LineGraph.js
import React, { useRef, useEffect } from 'react';
import * as d3 from 'd3';

const LineGraph = () => {
  const svgRef = useRef(null);

  useEffect(() => {
    // Data
    const data = [
      { time: '6am', amount: 2 },
      { time: '12pm', amount: 4 },
      { time: '6pm', amount: 3 },
      { time: '12am', amount: 1 },
    ];

    // Dimensions
    const width = 300;
    const height = 400;
    const margin = { top: 20, right: 30, bottom: 30, left: 40 };

    // Scales
    const x = d3.scalePoint()
      .domain(data.map(d => d.time))
      .range([margin.left, width - margin.right])
      .padding(0.5);

    const y = d3.scaleLinear()
      .domain([0, d3.max(data, d => d.amount)])
      .nice()
      .range([height - margin.bottom, margin.top]);

    // Line generator
    const line = d3.line()
      .x(d => x(d.time))
      .y(d => y(d.amount));

    // Create SVG
    const svg = d3.select(svgRef.current)
      .attr('width', width)
      .attr('height', height);

    // Clear previous content
    svg.selectAll('*').remove();

    // Add X axis
    svg.append('g')
      .attr('transform', `translate(0,${height - margin.bottom})`)
      .call(d3.axisBottom(x));

    // Add Y axis
    svg.append('g')
      .attr('transform', `translate(${margin.left},0)`)
      .call(d3.axisLeft(y));

    // Add line
    svg.append('path')
      .datum(data)
      .attr('fill', 'none')
      .attr('stroke', 'blue')
      .attr('stroke-width', 2)
      .attr('d', line);

    // Add grid lines (optional)
    svg.append('g')
      .attr('stroke', '#ddd')
      .selectAll('line')
      .data(y.ticks())
      .enter()
      .append('line')
      .attr('x1', margin.left)
      .attr('x2', width - margin.right)
      .attr('y1', d => y(d))
      .attr('y2', d => y(d));
  }, []);

  return (
    <div style={{ width: '300px', height: '400px', border: '1px solid #ccc', padding: '10px' }}>
      <svg ref={svgRef}></svg>
    </div>
  );
};

export default LineGraph;
