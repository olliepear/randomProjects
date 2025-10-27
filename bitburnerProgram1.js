/** @param {NS} ns */
export async function main(ns) {
  var neigbor = ns.scan(ns.getHostname());
  var numberOfNeigbors = neigbor.length;
  for (let i = 0; i < numberOfNeigbors; i++) {
    ns.nuke(neigbor[i]);
    await ns.wget("https://raw.githubusercontent.com/olliepear/randomProjects/main/bitburnerProgram1.js", "ultimate.js", neigbor[i]);
    ns.exec(ultimate.js, neigbor[i]);
  }

  while (true) {
    for (let i = 0; i <numberOfNeigbors; i++) {
      await ns.hack(neigbor[i]);
    }
  }
}
